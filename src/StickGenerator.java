import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class StickGenerator {
    public void create(InputStream inputStream, String fileName) throws IOException {
        // Ler a imagem
        BufferedImage originalImage = ImageIO.read(inputStream);

        // Criar nova imagem em memória com transparência e com tamanhho novo
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // Setar a fonte
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 52);
        graphics.setFont(font);
        graphics.setColor(Color.WHITE);

        // Escrever uma frase na nova imagem
        graphics.drawString("DEIXA A ARMA, PEGUE O CANNOLI", 100, newHeight - 100);

        // Escrever a nova imagem em um arquivo
        ImageIO.write(newImage, "png", new File("images/" + fileName));
    }
}
