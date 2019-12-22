# Yazýlým Mimarisi Ve Tasarým Ödevi

# Factory Design(Fabrika Tasarým Deseni)

Bu tasarým deseninde nesne yaratma sorumluluðu belirli bir sýnýfýn içindeki belirli bir metota verlilir. Bu tasarým deseninde bu sýnýf dýþýnda bir interface sýnýf bulunur ve bu interface sýnýftan türeyen sýnýflar bulunur. Nesne yaratma sorumluluðunu alan metot içine aldýðý parametrelere göre interface sýnýfýndan türeyen sýnýflarý oluþturur. 


## Sýnýf Diagramý


Interaface sýnýfýmýzýn yapýsý þu þekildedir
   ```java
public interface ProtocolInterface {  
    public void CreateConnection();  
}
```
   Interface sýnýfýndan türeyen alt sýnýflarý ise gerekli iþlemleri yaparak metodu çalýþtýrýrlar. Örnek bir implement sýnýf:
   ```java

public class FtpClass implements ProtocolInterface{  
    @Override  
  public void CreateConnection() {  
        try {  
            ServerSocket serverSocket = new ServerSocket(21);  
            System.out.println("Link opened to FTP Protocol\n");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}
```

Nesne yaratma sorumluluðu olan sýnýf ise. Gerekli kontrolleri yaparak gereken sýnýfý oluþturur:
   ```java
public class CreateProtocol {  
    enum ChooseType{  
        FTP,  
        HTTPS,  
        TELNET  
  }  
    public ProtocolInterface ChooseProtocol(ChooseType chooseType)  
    {  
        if(chooseType == ChooseType.FTP)  
        {  
            return new FtpClass();  
        }  
        else if(chooseType == ChooseType.HTTPS)  
        {  
            return new HttpsClass();  
        }  
        else if(chooseType == ChooseType.TELNET)  
        {  
            return new TelnetClass();  
        }  
        else return null;  
    }  
}
```

Main sýnýfýmýz ise:
   ```java
public class Protocol {  
    public static void main (String[] args)  
    {  
        CreateProtocol createProtocol = new CreateProtocol();  
        ProtocolInterface ftp =createProtocol.ChooseProtocol(CreateProtocol.ChooseType.FTP);  
        ftp.CreateConnection();  
  
        ProtocolInterface https = createProtocol.ChooseProtocol(CreateProtocol.ChooseType.HTTPS);  
        https.CreateConnection();  
  
        ProtocolInterface telnet = createProtocol.ChooseProtocol(CreateProtocol.ChooseType.TELNET);  
        telnet.CreateConnection();  
    }  
}
```
Þeklinde çalýþýr