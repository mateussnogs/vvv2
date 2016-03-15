package Tela;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tela extends JFrame{
    public static final int MONITOR_PRINCIPAL = 0;
    
    public Tela(){}
    
    public final void mostrar(){
        this.mostrar(this.getCentro(MONITOR_PRINCIPAL));
    }
    
    public void mostrar(Point posicao){
        this.setVisible(true);
        this.setLocation(posicao);
    }
    
    public void esconder(){
        this.setVisible(false);
    }
    
    public final void mostrarDialogoDeError(String mensagem){
        JOptionPane.showMessageDialog(this, mensagem, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    protected void abrirTelaRelativa(Tela tela){
        this.esconder();
        
        Point pos = this.getLocation();
        pos.x     += (this.getWidth() / 2) - (tela.getWidth() / 2);
        pos.y     += (this.getHeight() / 2) - (tela.getHeight() / 2);
        
        tela.mostrar(pos);
    }
    
    public final void centralizar(int monitorId){
        this.setLocation(this.getCentro(monitorId));
    }
    
    private Point getCentro(int monitorId){
        Rectangle limites;
        GraphicsDevice[] aparelhos =
                GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getScreenDevices();
        
        //monitorId Inválido, usar principal
        if (monitorId >= aparelhos.length || monitorId < 0){
            monitorId = Tela.MONITOR_PRINCIPAL;
        }
        
        limites = aparelhos[monitorId].getDefaultConfiguration().getBounds();
        
        return new Point(
                (limites.width - this.getWidth()) / 2 + limites.x,
                (limites.height - this.getHeight()) / 2 + limites.y
        );
    }
}
