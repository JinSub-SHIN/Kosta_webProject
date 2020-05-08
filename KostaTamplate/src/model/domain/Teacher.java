package model.domain;

public class Teacher extends Person {
   private Category category;
   private String pictureName;
     
   public Teacher() {}
   
   
   public Teacher(Category category, String pictureName) {
      super();
      this.category = category;
      this.pictureName = pictureName;
   }
   
   public Teacher(String id, String pwd, String name, String phone, String gender, int status, Category category,
		String pictureName) {
	super(id, pwd, name, phone, gender, status);
	this.category = category;
	this.pictureName = pictureName;
}

public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public String getPictureName() {
      return pictureName;
   }

   public void setPictureName(String pictureName) {
      this.pictureName = pictureName;
   }

}