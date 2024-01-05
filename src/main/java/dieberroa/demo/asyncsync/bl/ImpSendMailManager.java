package dieberroa.demo.asyncsync.bl;

import dieberroa.demo.asyncsync.api.SendEmail;

public class ImpSendMailManager implements SendEMailManager{

    private SendEmail _SendEmail;

    public ImpSendMailManager(SendEmail _SendEmail) {
        this._SendEmail = _SendEmail;
    }

    public Boolean sendEmail() {
        return _SendEmail.sendEmail("dieberroa@gmail.com", "Demo desde Java", "Hola, este es un mensaje de prueba.");
    }
    
}
