package AjaClassGetSet;

// Ini adalah sebuah kelas Java bernama DataClass yang berfungsi untuk merepresentasikan data yang memiliki
// beberapa atribut seperti dataTitle, dataDesc, dataDesc2, dan dataImage.
// Kelas ini memiliki getter dan setter untuk mengakses dan mengubah nilai-nilai atribut tersebut.
public class DataClass {

    private String dataTitle;
    private String dataDesc;
    private String dataDesc2;
    private int dataImage;

    public String getDataTitle() {
        return dataTitle;
    }

    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }

    public String getDataDesc2() {
        return dataDesc2;
    }

    public void setDataDesc2(String dataDesc2) {
        this.dataDesc2 = dataDesc2;
    }

    public int getDataImage() {
        return dataImage;
    }

    public void setDataImage(int dataImage) {
        this.dataImage = dataImage;
    }

    public DataClass(String dataTitle, String dataDesc, String dataDesc2, int dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataDesc2 = dataDesc2;
        this.dataImage = dataImage;
    }
}
