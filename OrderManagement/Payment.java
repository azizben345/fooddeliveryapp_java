package OrderManagement;

public class Payment implements ExtraCost
{
	private int paymentId;
	private String paymentType;
	private double amount;

	
	public Payment (int id, String payType, double amount) {
        paymentId = id;
        paymentType = payType;
        this.amount = amount;
    }
    public Boolean processPayment()
	{
		return true;
    }
    public double calcTotal() {
		if (paymentType.equals("Online Banking (FPX)"))
			return amount + DeliveryCharge + FPXCharge;
        return amount + DeliveryCharge;
    }

	public int getPaymentId() { return paymentId; }
	public void setPaymentId(int pay) { this.paymentId = pay; }
	public String getPaymentType() { return paymentType; }
	public void setPaymentType(String payT) { this.paymentType = payT; }
	public double getAmount() { return amount; }
	public void setAmount(double amount) { this.amount = amount; }
}
