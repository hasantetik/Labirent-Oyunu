/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labirent_oyunu;




public class karakter extends Labirent {
    public Labirent labirent;
    
 
   
    
    public boolean duvarıGuncelle(int x, int y) {
		
		boolean basarili = false;
		
		if(labirent.matris[y][x] == labirent.ZEMIN || labirent.matris[y][x] == labirent.ADAM){
			labirent.matris[labirent.getAdamY()][labirent.getAdamX()] = labirent.ZEMIN; // şu an ki bulunduğu yeri boşluk olarak belirle
			labirent.matris[y][x] = labirent.ADAM; // labirentte kutunun yerini değiştir
			//labirent.getAdamX() = x;
			//adamY = y;
			
			basarili = true;
		}	
		return basarili;

    }
    public boolean gAl(int x,int y){
            
        
        
            boolean basarili = false;
             
            if(labirent.matris[y][x] == labirent.getGUCLUYUMRUK() || labirent.matris[y][x] == labirent.ZEMIN){
                
               
                   labirent.matris[labirent.getgy()][labirent.getgy()] = labirent.ZEMIN;  
               
                   //gx=x;
                   //gy=y;
                   
                  
                   
                   
              
                basarili = true;
            }
  
            return basarili;
}
}
