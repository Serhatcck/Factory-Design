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
