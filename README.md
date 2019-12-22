# Yazılım Mimarisi Ve Tasarım Ödevi

# Factory Design(Fabrika Tasarım Deseni)

Bu tasarım deseninde nesne yaratma sorumluluğu belirli bir sınıfın içindeki belirli bir metota verlilir. Bu tasarım deseninde bu sınıf dışında bir interface sınıf bulunur ve bu interface sınıftan türeyen sınıflar bulunur. Nesne yaratma sorumluluğunu alan metot içine aldığı parametrelere göre interface sınıfından türeyen sınıfları oluşturur. 


## Sınıf Diagramı

![Factory Disagn](https://github.com/Serhatcck/Factory-Design/blob/master/FactoryDesignClass.PNG)

Interaface sınıfımızın yapısı şu şekildedir
   ```java
public interface ProtocolInterface {  
    public void CreateConnection();  
}
```
   Interface sınıfından türeyen alt sınıfları ise gerekli işlemleri yaparak metodu çalıştırırlar. Örnek bir implement sınıf:
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

Nesne yaratma sorumluluğu olan sınıf ise. Gerekli kontrolleri yaparak gereken sınıfı oluşturur:
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

Main sınıfımız ise:
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
Şeklinde çalışır
