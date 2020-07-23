/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labirent_oyunu;

/**
 *
 * @author Ben
 */
public class Labirent {
     protected int adamX, adamY;
     private int hedefX, hedefY;
     private int puan=0;
        
	
         private int kutuX,kutuY;
         private int HedefKutuX,HedefKutuY;
         private int elmasX,elmasY;
         private int elmas1X,elmas1Y;
         private int gx;
         private int gy;
       
       
        
         
	public  final int ZEMIN = 1;
	public  static final int DUVAR = 2;
	public   final int ADAM = 3;
	public   final int CIKIS = 4;
        public static final int KUTU=5;
        public static final int ELMAS=6; 
        public static final int ELMAS1=7;
        public static final int GUCLUYUMRUK=9;
        public static final int YIKILABILIRDUVAR=8;
        

	
	public int matris[][];

	public Labirent(){
	adamX = adamY = hedefX = hedefY = 0;
        kutuX=kutuY=HedefKutuX=HedefKutuY=0;
        elmasY=elmasX=gx=gy=0;
		matris = null;
	}
	
	public Labirent(int[][] grid){
		adamX = adamY = hedefX = hedefY = 0;
                kutuX=kutuY=HedefKutuX=HedefKutuY=0;
            elmasY=elmasX=gy=gx=0;
                
		yukle(grid);
		
	}


	public void yukle(int[][] grid) {
		
		matris = new int[grid.length][grid[0].length];
		
		for (int y = 0; y < grid.length; y++){
			for(int x = 0; x < grid[0].length; x++){
				int hucre = grid[y][x];
				if(hucre == ADAM){
					adamX = x;
					adamY = y;
				} 
                               
				if(hucre == CIKIS){
					hedefX = x;
					hedefY = y;
                                
				}
                                if(hucre==ELMAS){
                                    elmasX=x;
                                    elmasY=y;
                                }
                                if(hucre==ELMAS1){
                                    elmas1X=x;
                                    elmas1Y=y;
                                }
                                if(hucre==GUCLUYUMRUK){
                                    gx=x;
                                    gy=y;
                                }

                                if(hucre==KUTU){
                                    kutuX=x;
                                    kutuY=y;
                                }
 				matris[y][x] = grid[y][x];
			}
		}
		
	}
	
	public int getAdamX() {
		return adamX;
	}


	public int getAdamY() {
		return adamY;
	}


	public int getHedefX() {
		return hedefX;
	}

	public int getHedefY() {
		return hedefY;
	}
        public int getKutuX(){
            return kutuX;
        }
        public int getKutuY(){
            return kutuY;
        }
        public int getHedefKutuX(){
            return HedefKutuX;
        }
        public int getHedefKutuY(){
            return HedefKutuY;
        }
        public int getElmasX(){
            return elmasX;
        }
        public int getElmasY(){
            return elmasY;
        }
        public int getPuan(){
            return puan;
        }
        public int getElmas1Y(){
            return elmas1Y;
        }
        public int getElmas1X(){
            return elmas1X;
        }
        public int getgx(){
            return gx;
        }
        public int getgy(){
            return gy;
        }
        public int getGUCLUYUMRUK(){
            return GUCLUYUMRUK;
        }
		
     @Override
	public String toString() {

		String s = "";
		
		for (int y = 0; y < matris.length; y++){
			for(int x = 0; x < matris[0].length; x++){
				int hucre = matris[y][x];
				
				switch(hucre){
					case ZEMIN: 
						s += "-";
						break;
					case DUVAR: 
						s += "E";
						break;
					case ADAM:
						s += "ö";
						break;
                                        case KUTU:
                                              s=s+"K";
                                              break;
                                        case ELMAS:
                                            s=s+"E";
                                           break;
                                           case ELMAS1:
                                            s=s+"E";
                                           break;
					case CIKIS: 
						s += (char)169;
						break;
                                        case GUCLUYUMRUK:
                                              s=s+"G";
                                              break;
                                        case YIKILABILIRDUVAR:
                                            s=s+"Y";
                                            break;
                                                
				}
				
			}
			s += "\n";
		}
		
		return s;
		
	}

	public boolean adaminYeriniGuncelle(int x, int y) {
		
		boolean basarili = false;
		
		if(matris[y][x] == ZEMIN || matris[y][x] == CIKIS){
			matris[adamY][adamX] = ZEMIN; // şu an ki bulunduğu yeri boşluk olarak belirle
			matris[y][x] = ADAM; // labirentte kutunun yerini değiştir
			adamX = x;
			adamY = y;
			
			basarili = true;
		}	
		return basarili;

}
        public boolean kutununYeriniGuncelle(int x, int y) {
		
		boolean basarili = false;
		
		if(matris[y][x] == KUTU || matris[y][x] == ZEMIN){
			matris[kutuY][kutuX] = ZEMIN; // şu an ki bulunduğu yeri boşluk olarak belirle
			matris[y][x] = KUTU; // labirentte adamın yerini değiştir
                     //  matris[y][x]=ADAM;
		        
                        kutuX=x;
                        kutuY=y;
                        
			
			basarili = true;
		}
                return basarili;
}
        public boolean elmasAl(int x,int y){
            
            boolean basarili = false;
             
            if(matris[y][x] == ELMAS || matris[y][x] == ZEMIN){
                
               
                   matris[elmasY][elmasX] = ZEMIN;  
               
                 //  elmasX=x;
                 //  elmasY=y;
                   
                   puan=puan+100;
                   
                   
              
                basarili = true;
            }
  
            return basarili;
        }
                public boolean elmasAl1(int x,int y){
            
            boolean basarili = false;
             
            if(matris[y][x] == ELMAS1 || matris[y][x] == ZEMIN){
                
               //    matris[elmasY][elmasX-4] = ZEMIN;
                 //  elmasX++;
                   matris[elmas1Y][elmas1X] = ZEMIN;  
               
                //   elmas1X=x;
                 //  elmas1Y=y;
                   
                   puan=puan+100;
                   
                   
              
                basarili = true;
            }
  
            return basarili;
        }
                public boolean gAl(int x,int y){
            
            boolean basarili = false;
             
            if(matris[y][x] == GUCLUYUMRUK || matris[y][x] == ZEMIN){
                
               
                   matris[gy][gx] = ZEMIN;  
               
                   //gx=x;
                   //gy=y;
                   
                  
                   
                   
              
                basarili = true;
            }
  
            return basarili;
}

}
