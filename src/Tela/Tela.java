package Tela;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;

public class Tela extends JFrame{
    public static final int MONITOR_PRINCIPAL = 0;
    
    public Tela(){}
    
    public void mostrar(){
        this.setVisible(true);
        this.centralizar(MONITOR_PRINCIPAL);
    }
    
    public void mostrar(Point posicao){
        this.setVisible(true);
        this.setLocation(posicao);
    }
    
    public void esconder(){
        this.setVisible(false);
    }
    
    protected void abrirTelaRelativa(Tela tela){
        this.esconder();
        tela.mostrar(this.getLocation());
    }
    
    public final void centralizar(int monitorId){
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
        this.setLocation(
                (limites.width - this.getWidth()) / 2 + limites.x,
                (limites.height - this.getHeight()) / 2 + limites.y
        );
    }
}
