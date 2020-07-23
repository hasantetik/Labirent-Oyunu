/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labirent_oyunu;

import java.util.Scanner;

/**
 *
 * @author Ben
 */
public class Oyun {
     private Labirent labirent;
     private karakter karakter;

   
	
	
	public static final int YUKARI = 1;
	public static final int ASAGI = 2;
	public static final int SAGA = 3;
	public static final int SOLA = 4;
	public static final int HATALI = 0;

     
        
	
	private int adım;
	
	public Oyun(){
		labirent = null;
		adım = 0;
	}
	
	public Oyun(int[][] matris){
		adım = 0;
		yukle(matris);
	}
	
	public void yukle(int[][] matris){
		
	labirent = new Labirent(matris);
        
               
              
         
	}
	
	public void baslat(){
              
		while(true){
                    
                //    int adamX=labirent.getAdamX();
			sahneyiYazdir();
			int yon = kullanicidanYonBilgisiAl();
			adamiHareketEttir(yon);
                     
                    
                /*      if((labirent.getAdamY()==labirent.getElmasY()) && (adamX==labirent.getElmasX()-5)){//ilk elmas
                             labirent.elmasAl(labirent.getAdamY(),labirent.getAdamX() );
                            adamiHareketEttir(yon);
                        
                           }
                        
*/
                       if((labirent.getAdamY()==labirent.getElmasY()) && (labirent.getAdamX()+1==labirent.getElmasX())){
                           
                             labirent.elmasAl(labirent.getAdamY(),labirent.getAdamX() );
                             adamiHareketEttir(yon);
                           }
                       if((labirent.getAdamY()==labirent.getElmasY()) && (labirent.getAdamX()==labirent.getElmasX()+1)){
                           
                             labirent.elmasAl(labirent.getAdamY(),labirent.getAdamX() );
                             adamiHareketEttir(yon);
                           }
                       if((labirent.getAdamY()==labirent.getElmas1Y()) && (labirent.getAdamX()+1==labirent.getElmas1X())){
                           
                             labirent.elmasAl1(labirent.getAdamY(),labirent.getAdamX() );
                             adamiHareketEttir(yon);
                           }
                      
                      if((labirent.getAdamY()==labirent.getKutuY()) && ((labirent.getAdamX()+1)==labirent.getKutuX())){
                           kutuyuHareketEttir(yon);
                           adamiHareketEttir(yon);
                           
                         }
                      if((labirent.getAdamY()+1==labirent.getKutuY()) && (labirent.getAdamX()==labirent.getKutuX())){
                           kutuyuHareketEttir(yon);
                           adamiHareketEttir(yon);
                           
                         }
                   /*   if((labirent.getAdamY()==labirent.getgy()) && (labirent.getAdamX()+1==labirent.getgx())){
                           
                               
                             karakter.gAl(labirent.getAdamX(),labirent.getAdamY());
                             adamiHareketEttir(yon);
                           }
                      if((labirent.getAdamY()==labirent.getgy()) && (labirent.getAdamX()==labirent.getgx()+1)){
                           
                            
                             labirent.gAl(labirent.getAdamY(),labirent.getAdamX());
                             adamiHareketEttir(yon);
                           }
*/
                       if((labirent.getAdamY()==labirent.getgy()) && (labirent.getAdamX()+1==labirent.getgx())){ 
                             labirent.gAl(labirent.getAdamY(),labirent.getAdamX());
                             adamiHareketEttir(yon);
                           }
                     
                      
                      
                  
                      
                     
    
            
                       
			if(bittiMi())
				break;
		}
		
	
        }
	private boolean bittiMi() {
		boolean oyunBitti = false;
                
		 if(labirent.getPuan()==200){
		if(labirent.getAdamX() == labirent.getHedefX() && labirent.getAdamY() == labirent.getHedefY()){
                   
                        
			oyunBitti = true;  
                        System.out.println("Puanınız   :"+labirent.getPuan());
                        System.out.println("Tebrikler! Çıkışı buldunuz");
                    }
			
		}
		return oyunBitti;

	}

	private void adamiHareketEttir(int yon) {
            
		
		switch(yon){
                  
			
			case YUKARI:
				if(labirent.adaminYeriniGuncelle(labirent.getAdamX(), labirent.getAdamY()-1))
					adım++;
				break;
				
			case SOLA:
				if(labirent.adaminYeriniGuncelle(labirent.getAdamX()-1, labirent.getAdamY()))
                                    
                                
					adım++;
				break;
	
			case ASAGI:
				if(labirent.adaminYeriniGuncelle(labirent.getAdamX(), labirent.getAdamY()+1))
					adım++;
				break;
			
			case SAGA:
				if(labirent.adaminYeriniGuncelle(labirent.getAdamX()+1, labirent.getAdamY()))
					adım++;
				break;
                                
		}
                
	}
        private void kutuyuHareketEttir(int yon){
            
            switch(yon){
			
			case YUKARI:
				if(labirent.kutununYeriniGuncelle(labirent.getKutuX(), labirent.getKutuY()-1))
                                  	
				break;
				
			case SOLA:
				if(labirent.kutununYeriniGuncelle(labirent.getKutuX()-1, labirent.getKutuY()))
					
				break;
	
			case ASAGI:
				if(labirent.kutununYeriniGuncelle(labirent.getKutuX(), labirent.getKutuY()+1))
					
				break;

			
			 case SAGA:
				if(labirent.kutununYeriniGuncelle(labirent.getKutuX()+1,labirent.getKutuY()))
				break;
                                
		}
            
            
        }
        

	private int kullanicidanYonBilgisiAl() {
		
		Scanner consol = new Scanner(System.in);
		
		System.out.print("Yön Tuşları (w = yukarı, s = aşağı, a = sol, d = sağ), seçiniz: ");
		String secimStr = consol.next();
		
		char secim = secimStr.charAt(0);
		int yon = HATALI;
		
		switch(secim){
			case 'w':
			case 'W': 
				yon = YUKARI;
				break;
				
			case 'a':
			case 'A':
				yon = SOLA;
				break;
				
			case 's':
			case 'S':	
				yon = ASAGI;
				break;
				
			case 'd':
			case 'D':	
				yon = SAGA;
				break;
	
		}

		return yon;

	}

	public void sahneyiYazdir(){
		System.out.println("-------------------------\n");
		          System.out.println("******************");
                          System.out.println("   -HOSGELDİNİZ-");
                          System.out.println("******************");
                          
		System.out.println(labirent);
                
		
		System.out.println("\n Toplam Adım: "+adım);
                System.out.println("Puanınız : "+ labirent.getPuan());
		System.out.println("\n-------------------------\n");
		
	}
    
}
