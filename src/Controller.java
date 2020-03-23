public class Controller {
    private static Service service = new Service();

    public Controller(){
    }
    public static void createChild(){
        service.createChild();
    }
    public static void deleteChild(){
        service.deleteChild();
    }
    public static void displayChildList(){
        service.displayChildList();
    }
    public static void createParent(){
        service.createParent();
    }
    public static void deleteParent(){
        service.deleteParent();
    }
    public static void displayParentList(){
        service.displayParentList();
    }
    public static void createTeacher(){
        service.createTeacher();
    }
    public static void deleteTeacher(){
        service.deleteTeacher();
    }
    public static void displayTeacherList(){
        service.displayTeacherList();
    }
    public static void createAppointment(){
        service.createAppointment();
    }
    public static void deleteAppointment(){
        service.deleteAppointment();
    }
    public static void displayAppointmentList(){
        service.displayAppointmentList();
    }
    public static void displayRowFromAppointmentList(){
        service.displayRowFromAppointmentList();
    }
    public static void createRecordInWaitingList(){
        service.createRecordInWaitingList();
    }
    public static void deleteRecordInWaitingList(){
        service.deleteRecordInWaitingList();
    }
    public static void displayWaitingList(){
        service.displayWaitingList();
    }
    public static void displayRowFromWaitingList(){

        service.displayWaitingList();
    }
    public static void createSchedule(){
        service.createSchedule();
    }
    public static void displaySchedule()
    {
        service.displaySchedule();
    }
    public static void deleteSchedule()
    {
        service.deleteSchedule();
    }
    public static void createActivity(){
        service.createActivity();
    }
    public static void deleteActivity(){
        service.deleteActivity();
    }
    public static void displayAcitivties(){
        service.displayAcitivties();
    }
    public static void createInvoice(){
        service.createInvoice();
    }
    public static void deleteInvoice(){
        service.deleteInvoice();
    }
    public static void displayInvoicesList(){
        service.displayInvoicesList();
    }
    public static void createGroup(){
        service.createGroup();
    }
    public static void deleteGroup(){
        service.deleteGroup();
    }
    public static void displayGroups(){
        service.displayGroups();
    }
}
