package OrderManagement;

public interface ExtraCost {
    double DeliveryCharge = 3.0;
    double FPXCharge = 0.5;

    double calcTotal();
}