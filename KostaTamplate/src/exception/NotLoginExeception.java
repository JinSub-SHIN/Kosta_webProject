package exception;

public class NotLoginExeception extends Exception {
   public NotLoginExeception() {
         
   }

   public NotLoginExeception(String message) {
      super(message);
   }
}