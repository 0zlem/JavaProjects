public class Drayga extends Beyblade{
    private  String kutsalCanavar;
    public Drayga(String beybladeci, int donusHizi, int saldiriGucu,String kutsalCanavar) {
        super(beybladeci, donusHizi, saldiriGucu);
        this.kutsalCanavar=kutsalCanavar;
    }

    @Override
    public void bilgileriGoster() {
        super.bilgileriGoster();
        System.out.println("Kutsal Canavar Adı: "+kutsalCanavar);
    }

    @Override
    public void kutsalCanavarOrtayaCikar() {
        System.out.println(getBeyblade()+" "+kutsalCanavar+" ı ortaya çıkarıyor...");
        System.out.println(getBeyblade()+" ın Saldırısı: Kaplan pençesi");
    }
}
