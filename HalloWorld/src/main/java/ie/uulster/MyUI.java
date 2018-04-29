package ie.uulster;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.sass.internal.selector.PlaceholderSelector;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.GridDragEndEvent;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    ArrayList<Student> students = new ArrayList<Student>();
    

@Override
    protected void init(VaadinRequest vaadinRequest)
    {
        final VerticalLayout layout = new VerticalLayout();

        final TextField stuIdTextField = new TextField();
        stuIdTextField.setCaption("Enter Student ID:");

        final TextField studentTextField = new TextField();
        studentTextField.setCaption("Enter Student Name:");

        final TextField markTexField = new TextField();
        markTexField.setCaption("Enter Student mark:");
        
        final Label gradeLable1 = new Label();

        Button gradeButton  = new Button ("Grade Student");

        Grid <Student> grid=new Grid<>();
        grid.setItems(students);
        grid.addColumn(Student::getStuID).setCaption("ID");
        grid.addColumn(Student::getName).setCaption("Name");
        grid.addColumn(Student::getMark).setCaption("Mark");
        grid.addColumn(Student::getGrade).setCaption("Grade");
        
        gradeButton.addClickListener (e -> {
            String grade=calculateGrade(Integer.parseInt(markTexField.getValue()));
            gradeLable1.setValue(studentTextField.getValue()+ "'s grade is " + grade);
            String name = studentTextField.getValue();
            int mark=Integer.parseInt(markTexField.getValue());
            String stuID=checkStuID(stuIdTextField.getValue());
            if (stuID!="ID Exist")
            {
                students.add(new Student(name,mark,grade,stuID));
            }
            grid.getDataProvider().refreshAll();

            // Calculate grade here based on mark
            // Convert the String 'mark' into an integer
            // add CalculateGrade method
        });
        
        layout.addComponents(stuIdTextField,studentTextField, markTexField, gradeButton, gradeLable1,grid);
        
        setContent(layout);
}
private String checkStuID (String pStuID)
{

    for (int i=0;i<students.size();i++)
    {
        if (students.get(i).getStuID().equals(pStuID))
        {
            Notification.show("ID exist, enter another ID",
                  Notification.Type.WARNING_MESSAGE);
            pStuID="ID Exist";
        }
    }
    return pStuID;
}

private String calculateGrade(int mark1)
{
	String grade="";
            if (mark1 <40){
                 grade=" F";
            }
            else if (mark1<70)
           { grade=" Pass";}
           else { grade="Destinction";
        }
        return grade;
}

    @WebServlet(urlPatterns = "/*", name = "MygUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

		private static final long serialVersionUID = 1L;
    }
}
