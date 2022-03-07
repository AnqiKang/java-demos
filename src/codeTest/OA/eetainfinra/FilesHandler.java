package codeTest.OA.eetainfinra;

interface AudioPlayer {
    void playMp3(String file);
}

interface VideoPlayer {
    void playMp4(String file);
}

interface TextReader {
    void readText(String file);
}

class SimpleEBook implements TextReader {
    @Override
    public void readText(String file) {
        int index = file.lastIndexOf('.');
        String extension = file.substring(index);
        if (extension.equals(".txt")) {
            System.out.println("Read " + file + " on EBook");
        } else {
            System.out.println("Can't play " + file + " on EBook");
        }
    }
}

class PocketPlayer implements AudioPlayer {
    @Override
    public void playMp3(String file) {
        int index = file.lastIndexOf('.');
        String extension = file.substring(index);
        if (extension.equals(".mp3")) {
            System.out.println("Play " + file + " on Player");
        } else {
            System.out.println("Can't play " + file + " on Player");
        }

    }
}

class IPhone implements AudioPlayer, VideoPlayer, TextReader {

    @Override
    public void playMp3(String file) {
        System.out.println("Play " + file + " on Iphone");
    }

    @Override
    public void playMp4(String file) {
        System.out.println("Play " + file + " on Iphone");
    }

    @Override
    public void readText(String file) {
        System.out.println("Play " + file + " on Iphone");
    }
}

public class FilesHandler {
    public static void main(String[] args) {
//        String[] devices = {"Iphone", "Player", "EBook"};
//        String[] files = {"let-it-be.mp3", "titanic.mp4", "war-and-peace.txt"};
//        int n = 3;
//
//        for (int i = 0; i < n; i++) {
//            String device = devices[i];
//            String file = files[i];
//            solve(device, file);
//        }

        String[] devices = {"Player", "EBook"};
        String[] files = {"let-it-be.mp3", "let-it-be.mp3"};
        int n = 2;

        for (int i = 0; i < n; i++) {
            String device = devices[i];
            String file = files[i];
            solve(device, file);
        }

    }

    private static void solve(String device, String file) {
        int i = file.lastIndexOf('.');
        String extension = file.substring(i);

        if (device.equals("Iphone")) {
            IPhone iPhone = new IPhone();
            if (extension.equals(".mp3")) {
                iPhone.playMp3(file);
            } else if (extension.equals("mp4")) {
                iPhone.playMp4(file);
            } else if (extension.equals(".txt")) {
                iPhone.readText(file);
            } else {
                System.out.println("Can't play " + file + " on Iphone");
            }
        }
        if (device.equals("EBook")) {
            PocketPlayer pocketPlayer = new PocketPlayer();
            pocketPlayer.playMp3(file);

        }
        if (device.equals("EBook")) {
            SimpleEBook simpleEBook = new SimpleEBook();
            simpleEBook.readText(file);
        }

    }


}
