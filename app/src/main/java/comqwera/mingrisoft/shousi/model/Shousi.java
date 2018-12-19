package comqwera.mingrisoft.shousi.model;

public class Shousi {
        private String name;
        private int imageID;

        public Shousi(String name, int imageID) {
            this.name = name;
            this.imageID=imageID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getImageID() {
            return imageID;
        }

        public void setImageID(int imageID) {
            this.imageID = imageID;
        }

    }
