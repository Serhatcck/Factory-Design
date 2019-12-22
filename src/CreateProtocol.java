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
