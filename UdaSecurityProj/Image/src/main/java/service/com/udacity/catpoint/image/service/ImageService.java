package service.com.udacity.catpoint.image.service;

import java.awt.image.BufferedImage;

public interface ImageService {

    boolean imageContainsCat(BufferedImage img, float Confidence);
}
