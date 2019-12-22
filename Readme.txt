# Yaz�l�m Mimarisi Ve Tasar�m �devi

# Factory Design(Fabrika Tasar�m Deseni)

Bu tasar�m deseninde nesne yaratma sorumlulu�u belirli bir s�n�f�n i�indeki belirli bir metota verlilir. Bu tasar�m deseninde bu s�n�f d���nda bir interface s�n�f bulunur ve bu interface s�n�ftan t�reyen s�n�flar bulunur. Nesne yaratma sorumlulu�unu alan metot i�ine ald��� parametrelere g�re interface s�n�f�ndan t�reyen s�n�flar� olu�turur. 


## S�n�f Diagram�


Interaface s�n�f�m�z�n yap�s� �u �ekildedir
   ```java
public interface ProtocolInterface {  
    public void CreateConnection();  
}
```
   Interface s�n�f�ndan t�reyen alt s�n�flar� ise gerekli i�lemleri yaparak metodu �al��t�r�rlar. �rnek bir implement s�n�f:
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

Nesne yaratma sorumlulu�u olan s�n�f ise. Gerekli kontrolleri yaparak gereken s�n�f� olu�turur:
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

Main s�n�f�m�z ise:
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
�eklinde �al���r