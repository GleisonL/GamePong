package br.edu.unidavi.gamepong;


public class ServerStatus implements Runnable{
    private final Servidor servidor;
    
    //Tamanho da area
    private int altura = 638;
    private int largura = 815;

    private int direcaoX = 0;
    private int direcaoY = 0;
    private int posBolaY;
    private int posBolaX;    
    private int ponto = 0;
    private int velocidadeBola = 3;    
    private int pontuacaoA;
    private int pontuacaoB;

    public ServerStatus(Servidor servidor){
        this.servidor = servidor;
        //Iniciando a bola no meio da tela
        //posBarra1 = altura  / 2;
        //posBarra2 = altura  / 2;
        posBolaY  = altura  / 2;
        posBolaX  = largura / 2;
        
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(5);
                 //Todas as verificações para identificar as colisões com da bola com parede
                if((direcaoX == 0) && (posBolaX > 10)) {
                    posBolaX -= velocidadeBola;
                }
                else {
                    direcaoX = 1;
                }
                if((direcaoX == 1) && (posBolaX < (largura - 60))){
                    posBolaX += velocidadeBola;
                }
                else{
                    direcaoX = 0;
                }
                if((direcaoY == 0) && (posBolaY > 10)) {
                    posBolaY -= velocidadeBola;
                }
                else {
                    direcaoY = 1;
                }
                if((direcaoY == 1) && (posBolaY < (altura - 85))){
                    posBolaY += velocidadeBola;
                }
                else{
                    direcaoY = 0;
                }
                if(posBolaX > 100 && posBolaX < 600){
                    ponto = 0;
                }
                if(posBolaX >= ((largura / 4))){
                    //verificaBola(bola1, barraB);
                }
                else if(posBolaX <= ((largura / 4))){
                    //verificaBola(bola1, barraA);
                }
                else {
                  ponto = 0;
               }
               servidor.distribuiMensagem("bola01;" + posBolaX + ";" + posBolaY);
               servidor.distribuiMensagem("pontos;" + 3 + ";" + 5);
               //System.out.println("bola01;" + posBolaX + ";" + posBolaY);
            }
            catch (InterruptedException ex) {}
        }
    }

}

