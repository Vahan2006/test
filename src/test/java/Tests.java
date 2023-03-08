import Data.UserData;
import org.testng.annotations.Test;
import Methods.demoQA;

public class Tests {
    public UserData userData = new UserData();
    public demoQA demo = new demoQA();
    private String dragAndDropLink = "https://demoqa.com/droppable";
    private String homeLink = "https://demoqa.com/";
    private String sortLink = "https://demoqa.com/sortable";
    private String resizeLink = "https://demoqa.com/resizable";
    private String resizeBoxSelector = "#resizableBoxWithRestriction";
    private String resizeHandleSelector = ".react-resizable-handle";
    private String elementSelector = ".mt-4:nth-child(1)";
    private String widgetsSelector = ".mt-4:nth-child(4)";
    private String textBoxSelector = ".btn.btn-light:nth-child(1)";
    private String checkBoxSelector = ".btn.btn-light:nth-child(2)";
    private String checkUpDownLoadSelector = ".btn.btn-light:nth-child(8)";
    private String toolTipSelector = ".show>ul>#item-6";
    private String nameFieldSelector = "#userName.mr-sm-2.form-control";
    private String emailFieldSelector = "#userEmail.mr-sm-2.form-control";
    private String currenAdressSelectro = "#currentAddress";
    private String currenAdressSelectorResult = ".border.col-md-12.col-sm-12 > #currentAddress";
    private String parmanentAdressSelector = "#permanentAddress";
    private String parmanentAdressSelectorResult = ".border.col-md-12.col-sm-12 > #permanentAddress";
    private String toolTipButtonSelector = "#toolTipButton";
    private String uploadFileSelector = "#uploadFile";
    private String submitSelector = "#submit";
    private String dragToSelector= "#droppable";
    private String droped = "#droppable>p";
    private String userNameSelector = "#name";
    private String userEmailSeletor = "#email";
    private String classifiedCheckBoxSelector = ".rct-icon.rct-icon-check";
    private String dragFromSelector = ".drag-box";
    private String validDropped = "Dropped!";
    private String sortToSelector = ".list-group-item-action:nth-child(1)";
    private String sortFromSelector = ".list-group-item-action:nth-child(5)";
    private String userName = userData.userName;
    private String userEmail = userData.userEmail;
    private String currentAdress = userData.currentAddres;
    private String parmanentAdress = userData.parmanentAddres;
    private String uploadData = userData.uploadData;

    private String[] checkBoxPath = {
            ".rct-collapse.rct-collapse-btn",
            ".rct-node:nth-child(2) > .rct-text > button",
            "li>ol>.rct-node-expanded >ol>li:nth-child(2)>span>button",
            ".rct-node-leaf:nth-child(3)"};


    @Test
    public void TextBoxFunctionality() throws InterruptedException {
        demo.visitHomePage(homeLink);
        Thread.sleep(1000);
        demo.scrollTo(300);
        Thread.sleep(1000);
        demo.clickTheElement(elementSelector);
        Thread.sleep(1000);
        demo.clickTheElement(textBoxSelector);
        Thread.sleep(1000);
        demo.typeInTheBox(nameFieldSelector, userName);
        Thread.sleep(1000);
        demo.typeInTheBox(emailFieldSelector, userEmail);
        Thread.sleep(1000);
        demo.typeInTheBox(currenAdressSelectro, currentAdress);
        Thread.sleep(1000);
        demo.scrollTo(300);
        Thread.sleep(1000);
        demo.typeInTheBox(parmanentAdressSelector, parmanentAdress);
        Thread.sleep(1000);
        demo.clickTheElement(submitSelector);
        Thread.sleep(1000);
        demo.getTextAndAssert(userNameSelector, userName);
        Thread.sleep(1000);
        demo.getTextAndAssert(userEmailSeletor, userEmail);
        Thread.sleep(1000);
        demo.getTextAndAssert(currenAdressSelectorResult, currentAdress);
        demo.getTextAndAssert(parmanentAdressSelectorResult, parmanentAdress);

    }


    @Test
    public void CheckBox() throws InterruptedException {
        demo.visitHomePage(homeLink);
        Thread.sleep(1000);
        demo.scrollTo(300);
        Thread.sleep(1000);
        demo.clickTheElement(elementSelector);
        Thread.sleep(1000);
        demo.clickTheElement(checkBoxSelector);
        Thread.sleep(1000);
        demo.scrollTo(200);
        Thread.sleep(1000);
        demo.toggleClick(checkBoxPath);
        Thread.sleep(1000);
        demo.assertThatExists(classifiedCheckBoxSelector);
    }

    @Test
    public void hoverOver() throws InterruptedException {
        demo.visitHomePage(homeLink);
        Thread.sleep(1000);
        demo.scrollTo(300);
        Thread.sleep(1000);
        demo.clickTheElement(widgetsSelector);
        Thread.sleep(1000);
        demo.scrollTo(300);
        Thread.sleep(1000);
        demo.clickTheElement(toolTipSelector);
        Thread.sleep(1000);
        demo.hoverOver(toolTipButtonSelector);
        Thread.sleep(1000);
        demo.assertThatExists("[role = \"tooltip\"]");
    }

    @Test
    public void upload() throws InterruptedException {
        demo.visitHomePage(homeLink);
        Thread.sleep(1000);
        demo.scrollTo(300);
        Thread.sleep(1000);
        demo.clickTheElement(elementSelector);
        Thread.sleep(1000);
        demo.scrollTo(300);
        Thread.sleep(1000);
        demo.clickTheElement(checkUpDownLoadSelector);
        Thread.sleep(1000);
        demo.typeInTheBox(uploadFileSelector, uploadData);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        demo.visitHomePage(dragAndDropLink);
        Thread.sleep(1000);
        demo.scrollTo(100);
        Thread.sleep(1000);
        demo.dragAndDrop(dragFromSelector,dragToSelector);
        Thread.sleep(1000);
        demo.getTextAndAssert(droped,validDropped );
    }
    @Test
    public void dragAndDropSort() throws InterruptedException {
        demo.visitHomePage(sortLink);
        Thread.sleep(1000);
        demo.scrollTo(100);
        Thread.sleep(1000);
        demo.dragAndDrop(sortFromSelector,sortToSelector);
    }

    @Test
    public void resizeBox() throws InterruptedException {
        demo.visitHomePage(resizeLink);
        Thread.sleep(1000);
        demo.scrollTo(200);
        Thread.sleep(1000);
        demo.resize(resizeBoxSelector,resizeHandleSelector,30,30);
    }

}



