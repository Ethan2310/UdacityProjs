package com.udacity.catpoint.security.service;

import com.udacity.catpoint.security.data.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import service.com.udacity.catpoint.image.service.ImageService;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)


public class SecurityServiceTest {

    @Mock
    static ImageService imageService;
    @Mock
    static SecurityRepository securityRepository;
    static Sensor sensorDoor = new Sensor("testSensorDoor", SensorType.DOOR);
    static Sensor sensorWindow = new Sensor("testSensorWindow", SensorType.WINDOW);
    static Sensor sensorMotion= new Sensor("testSensorMotion", SensorType.MOTION);

    @Mock
    static BufferedImage bufferedImage;

    static SecurityService securityService;



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        securityService = new SecurityService(securityRepository, imageService);
        securityRepository.addSensor(sensorDoor);
       securityRepository.addSensor(sensorWindow);
        securityRepository.addSensor(sensorMotion);
    }

    @AfterAll
    public static void tearDown() {
        imageService = null;
        securityRepository = null;
        sensorDoor = null;
        sensorMotion = null;
        sensorWindow = null;
        securityService = null;
        bufferedImage = null;
    }

    @ParameterizedTest
    @EnumSource(value = ArmingStatus.class, names = {"ARMED_AWAY","ARMED_HOME"})
    @DisplayName("Test 1")
    public void setAlarmStatus_ifAlarmIsArmedAndSensorActivated_putSystemIntoPendingAlarm(ArmingStatus armingStatus) {

        //arrange
        when(securityRepository.getArmingStatus()).thenReturn(armingStatus);
        when(securityRepository.getAlarmStatus()).thenReturn(AlarmStatus.NO_ALARM);

        //act
        sensorDoor.setActive(false);
        securityService.changeSensorActivationStatus(sensorDoor, true);

        //assert
        verify(securityRepository).setAlarmStatus(AlarmStatus.PENDING_ALARM);
    }

    @ParameterizedTest
    @EnumSource(value = ArmingStatus.class, names = {"ARMED_AWAY","ARMED_HOME"})
    @DisplayName("Test 2")
    public void setAlarmStatus_ifAlarmArmedAndSensorActivatedAndAlarmPending_setAlarmStatusToAlarm(ArmingStatus armingStatus) {

        //arrange
        lenient().when(securityRepository.getArmingStatus()).thenReturn(armingStatus);
        lenient().when(securityRepository.getAlarmStatus()).thenReturn(AlarmStatus.PENDING_ALARM);

        //act
        securityService.changeSensorActivationStatus(sensorDoor, true);

        //verify
        verify(securityRepository).setAlarmStatus(AlarmStatus.ALARM);
    }

    @Test
    @DisplayName("Test 3")
    public void setAlarmStatus_ifPendingAlarmAndAllSensorsInactive_setNoAlarmState() {

        //arrange
        sensorDoor.setActive(true);
        when(securityRepository.getAlarmStatus()).thenReturn(AlarmStatus.PENDING_ALARM);

        //act
        securityService.changeSensorActivationStatus(sensorDoor, false);

        //assert
        verify(securityRepository, times(2)).setAlarmStatus(AlarmStatus.NO_ALARM);
    }

    @ParameterizedTest
    @ValueSource(booleans ={true,false})
    @DisplayName("Test 4")
    public void ifAlarmActive_changeInSensorStateShouldNotAffectAlarmState(boolean armState)
    {
        //arrange
        lenient().when(securityRepository.getAlarmStatus()).thenReturn(AlarmStatus.ALARM);
       // sensorDoor.setActive(armState);

        //act
        securityService.changeSensorActivationStatus(sensorDoor,!armState);

        //verify
        verify(securityRepository,never()).setAlarmStatus(any());

    }


    @Test
    @DisplayName("Test 5")
    public void setAlarmStatus_ifSensorActivatedWhileActiveAndSystemPending_changeToAlarmState()
    {
        // arrange
        when(securityRepository.getAlarmStatus()).thenReturn(AlarmStatus.PENDING_ALARM);

        //act
        securityService.changeSensorActivationStatus(sensorDoor,true);

        //verify
        verify(securityRepository).setAlarmStatus(AlarmStatus.ALARM);

    }

    @ParameterizedTest
    @EnumSource(value = AlarmStatus.class, names = {"NO_ALARM", "PENDING_ALARM", "ALARM"})
    @DisplayName("Test 6")
    public void setAlarmStatus_ifSensorDeactivatedWhileInactive_noChangeToAlarmState(AlarmStatus alarmStatus)
    {
        //act
        sensorDoor.setActive(false);
        securityService.changeSensorActivationStatus(sensorDoor,false);
        verify(securityRepository,never()).setAlarmStatus(any());

    }

    @Test
    @DisplayName("Test 7")
    public void setAlarmStatus_ifImageServiceIdentifiesAnImageContainingACatWhileSystemIsArmedHome_putSystemIntoAlarmStatus()
    {
        //arrange
        when(imageService.imageContainsCat(any(),anyFloat())).thenReturn(true);
        when(securityService.getArmingStatus()).thenReturn(ArmingStatus.ARMED_HOME);

        //act
        securityService.processImage(bufferedImage);

        //assert
        verify(securityRepository).setAlarmStatus(AlarmStatus.ALARM);
    }

    @Test
    @DisplayName("Test 8")
    public void setAlarmStatus_ifImageServiceIdentifiesImageNotContainingACat_changeStatusToNoAlarmAsLongAsSensorsAreNotActive()
    {
        //arrange
        lenient().when(imageService.imageContainsCat(any(),anyFloat())).thenReturn(false);
        Set<Sensor> inactiveSensors = new HashSet<>();
        inactiveSensors.add(sensorDoor);
        inactiveSensors.add(sensorMotion);
        inactiveSensors.add(sensorWindow);
        inactiveSensors.forEach(sensor -> sensor.setActive(false));
        lenient().when(securityService.getSensors()).thenReturn(inactiveSensors);

        //act
        securityService.processImage(bufferedImage);

        //assert
        verify(securityRepository).setAlarmStatus(AlarmStatus.NO_ALARM);
    }

    @Test
    @DisplayName("Test 9")
    public void setAlarmStatus_ifSystemIsDisarmed_setStatusToNoAlarm()
    {
        //act
        securityService.setArmingStatus(ArmingStatus.DISARMED);

        //assert
        verify(securityRepository).setAlarmStatus(AlarmStatus.NO_ALARM);
    }

    @ParameterizedTest
    @EnumSource(value = ArmingStatus.class, names = {"ARMED_AWAY","ARMED_HOME"})
    @DisplayName("Test 10")
    public void changeSensorActivationStatus_ifSystemIsArmed_resetAllSensorsToInactive(ArmingStatus armingStatus)
    {
       // arrange
        Set<Sensor> sensors = securityRepository.getSensors();
        sensors.forEach(sensor -> sensor.setActive(true));
        lenient().when(securityRepository.getArmingStatus()).thenReturn(ArmingStatus.DISARMED);
        when(securityRepository.getSensors()).thenReturn(sensors);

        //act
        securityService.setArmingStatus(armingStatus);

        //assert
        securityRepository.getSensors().forEach(sensor -> Assertions.assertFalse(sensor.getActive()));

    }

    @Test
    @DisplayName("Test 11")
    public void ifSystemIsArmedHomeWhileCameraShowsACat_setAlarmStatusToAlarm()
    {

      // arrange
        when(imageService.imageContainsCat(any(), anyFloat())).thenReturn(true);
        when(securityRepository.getArmingStatus()).thenReturn(ArmingStatus.ARMED_HOME);

       //act
        securityService.processImage(mock(BufferedImage.class));

        //assert
        ArgumentCaptor<AlarmStatus> captor = ArgumentCaptor.forClass(AlarmStatus.class);
        verify(securityRepository, atMostOnce()).setAlarmStatus(captor.capture());
        assertEquals(captor.getValue(), AlarmStatus.ALARM);

    }



}
