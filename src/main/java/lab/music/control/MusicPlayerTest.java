package lab.music.control;

import lab.music.entity.MP3;
import lab.music.entity.MusicMedia;
import lab.music.entity.Vinyl;

public class MusicPlayerTest {
    public static void main(String[] args) {
        System.out.println("===== 음악 재생 시스템 테스트 =====");

        System.out.println("\n--- MP3 테스트 ---");
        MP3 mp3 = new MP3("Dynamite", "BTS", 5);
        mp3.displayInfo();
        mp3.play();
        mp3.setVolume(8);
        mp3.play();
        mp3.stop();

        System.out.println("\n--- Vinyl 테스트 ---");
        Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
        vinyl.displayInfo();
        vinyl.play();
        vinyl.clean();

        System.out.println("\n--- 다형성 테스트 ---");
        MusicMedia media = new MP3("Butter", "BTS", 4);
        media.displayInfo();
        media.play();

        System.out.println("\n--- 캐스팅 테스트 ---");
        if (media instanceof MP3) {
            MP3 castedMP3 = (MP3) media;
            castedMP3.setVolume(3);
            castedMP3.play();
            castedMP3.setVolume(7);
            castedMP3.stop();
        }
    }
}

