package com.myapplicationdev.android.traffic;

public class cameras {

    private String timestamp;
    private int cameraId;
    //private int imageId;
    private String imageURL;

    public cameras(String timestamp, String imageURL) {
       // this.cameraId = cameraId;
        //this.imageId = imageId;
        this.imageURL = imageURL;
        this.timestamp= timestamp;
    }

    public int getCameraId() {
        return cameraId;
    }
//
    public void setCameraId(int cameraId) {
        this.cameraId = cameraId;
    }
//
//    public int getImageId() {
//        return imageId;
//    }
//
//    public void setImageId(int imageId) {
//        this.imageId = imageId;
//    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

//    @Override
//    public String toString() {
//        return "Cameras" +
//                "\ncameraId: " + cameraId +
//                "\nimageId: " + imageId;
//    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "cameras: " +
                "\ntimestamp='" + timestamp +
                "\nimageURL='" + imageURL ;
    }
}
