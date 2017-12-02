/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.Scanner;

/**
 *
 * @author mercedes
 */
public class CountryForIP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);

       System.out.println("Escriu la IP: ");
       String ip = scan.nextLine();
        GeoIP geoIP;
      try{ 
        geoIP = getGeoIP(ip);
       if (geoIP.getReturnCode() == 1){
        System.out.println("The IP address " + ip + " is located at " 
                + geoIP.getCountryName() + "(" + geoIP.getCountryCode() + ")");
       }
       else {
           System.out.println("No results for IP address " + ip);
       }
      }
      catch(Exception e){
          System.out.println("Exception for IP address: " + ip);
          
      }
    }

    private static GeoIP getGeoIP(java.lang.String ipAddress) {
        exam.GeoIPService service = new exam.GeoIPService();
        exam.GeoIPServiceSoap port = service.getGeoIPServiceSoap();
        return port.getGeoIP(ipAddress);
    }
    
}
