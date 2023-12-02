import java.util.Scanner;

public class ATM {
    public void calis(Hesap hesap) {
        Login login=new Login();
        Scanner input=new Scanner(System.in);

        System.out.println("ATM' ye HOŞ GELDİNİZ!");
        System.out.println("---------------------");
        System.out.println("Kullanıcı Girişi");
        System.out.println("---------------------");
        int girisHakki=3;

        while (true){
            if(login.login(hesap)){
                System.out.println("Giriş başarılı!");
                break;
            }
            else {
                System.out.println("Giriş başarısız..!");
                girisHakki--;
                System.out.println("Kalan giriş hakkı: "+girisHakki);
            }
            if (girisHakki==0){
                System.out.println("Giriş hakkınız bitti!!!");
                return;
            }
        }
        System.out.println("---------------------");
        while (true){
        String islemler="1-Bakiye Görüntüle \n"
                +"2-Para Yatırma \n"
                +"3-Para Çekme \n"
                +"Çıkış için q'ya basın";
        System.out.println(islemler);
        System.out.println("-----------------------");


            System.out.println("Yapmak istediğiniz işlemi seçiniz:");
            String islem=input.nextLine();
            if (islem.equals("q")){
                break;
            } else if (islem.equals("1")) {
                System.out.println("Bakiyeniz: "+hesap.getBakiye());
            } else if (islem.equals("2")) {
                System.out.println("Yatırmak istediğiniz tutar: ");
                int tutar=input.nextInt();
                input.nextLine();
                hesap.paraYatir(tutar);
            } else if (islem.equals("3")) {
                System.out.println("Çekmek istediğiniz tutar: ");
                int tutar=input.nextInt();
                input.nextLine();
                hesap.paraCek(tutar);
            }
            else {
                System.out.println("Geçersiz bir işlem türü seçtiniz!!!");
            }


        }

    }
}
