public class ATMMain {
    public static void main(String[] args) {
        ATM atm=new ATM();
        Hesap hesap=new Hesap("İmera","12345",2000);
        atm.calis(hesap);
        System.out.println("ATM'den çıkılıyor..!");

    }
}
