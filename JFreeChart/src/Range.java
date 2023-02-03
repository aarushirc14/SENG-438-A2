//WE NEED TO PICK 5 METHODS TO TEST FROM THIS

 public class Range implements java.io.Serializable {
   
   private static final long serialVersionUID = -906333695431863380L;
   
   private double lower;
   
   private double upper;
   
   public strictfp Range(double lower, double upper) {
   }
   
   public strictfp double getLowerBound() {
     return 0;
   }
   
   public strictfp double getUpperBound() {
     return 0;
   }
   
   public strictfp double getLength() {
     return 0;
   }
   
   public strictfp double getCentralValue() {
     return 0;
   }
   
   public strictfp boolean contains(double value) {
     return false;
   }
   
   public strictfp boolean intersects(double lower, double upper) {
     return false;
   }
   
   public strictfp double constrain(double value) {
     return 0;
   }
   
   public static strictfp org.jfree.data.Range combine(org.jfree.data.Range range1, org.jfree.data.Range range2) {
     return null;
   }
   
   public static strictfp org.jfree.data.Range expandToInclude(org.jfree.data.Range range, double value) {
     return null;
   }
   
   public static strictfp org.jfree.data.Range expand(org.jfree.data.Range range, double lowerMargin, double upperMargin) {
     return null;
   }
   
   public static strictfp org.jfree.data.Range shift(org.jfree.data.Range base, double delta) {
     return null;
   }
   
   public static strictfp org.jfree.data.Range shift(org.jfree.data.Range base, double delta, boolean allowZeroCrossing) {
     return null;
   }
   
   private static strictfp double shiftWithNoZeroCrossing(double value, double delta) {
     return 0;
   }
   
   public strictfp boolean equals(java.lang.Object obj) {
     return false;
   }
   
   public strictfp int hashCode() {
     return 0;
   }
   
   public strictfp java.lang.String toString() {
     return null;
   }
 }