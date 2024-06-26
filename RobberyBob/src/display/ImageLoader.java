package display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ImageLoader {

    final String imagePath = "/images/Sprite/";
    public int currentFrameIndex = 0;
    public int currentDirectionIndex = 0;
    public long lastFrameTime = System.currentTimeMillis();
    public long frameDelay = 120; // milli

    // load image and convert into bigger scale.
    public ImageIcon loadImage(String entity) {
        System.out.println(imagePath+entity+"/spritesheet.png");
        URL url = this.getClass().getResource(imagePath + entity + "/spritesheet.png");
        assert url != null;
        ImageIcon original = new ImageIcon(url);
        Image originalImage = original.getImage();
        Image scaledImage = originalImage.getScaledInstance(192, 256, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public Image[][] loadSpriteSheet(String entity, int frameWidth, int frameHeight, int rows, int cols) {
        ImageIcon spriteSheet = loadImage(entity);
        Image image = spriteSheet.getImage();

        // Convert Image to BufferedImage
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bufferedImage.createGraphics();
        bGr.drawImage(image, 0, 0, null);
        bGr.dispose();

        // Extract all frames and load it based on movement of entity
        Image[][] frames = new Image[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                frames[i][j] = bufferedImage.getSubimage(j * frameWidth, i * frameHeight, frameWidth, frameHeight);
            }
        }

        return frames;
    }


}
