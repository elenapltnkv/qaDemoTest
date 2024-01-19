
import org.junit.jupiter.api.Test;



public class BestPracticeFormTest extends Basic{
BestPracticeForm form = new BestPracticeForm();



    @Test
    public void fillDateToForm(){
        form.openPage();
        form.setName();
        form.setLastName();
        form.setEmail();
        form.chooseJender();
        form.setUserNumber();
        form.clickDateOfBirh("14", "January", "2014");
        form.setHobby();
        form.setAddres();
        form.submitForm();
        form.compareDateForm();
        System.out.println("end tests");
    }


}
