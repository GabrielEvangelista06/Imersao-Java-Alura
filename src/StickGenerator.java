import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StickGenerator {
    public void create() throws IOException {
        // Ler a imagem
        BufferedImage originalImage = ImageIO.read(new File("images/movie.jpg"));

        // Criar nova imagem em memória com transparência e com tamanhho novo
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage,0, 0, null);

        // Escrever uma frase na nova imagem

        // Escrever a nova imagem em um arquivo
        ImageIO.write(newImage, "png", new File("images/sticker.png"));
    }

    public static void main(String[] args) throws IOException {
        var generator = new StickGenerator();
        generator.create();
    }
}
