package lab.music.entity;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize;
    private int volume;

    // 생성자 1
    public MP3(String title, String artist, int fileSize) {
        super(title, artist, "MP3");
        this.fileSize = fileSize;
        this.volume = 5;  // 기본 볼륨
    }

    // 생성자 2
    public MP3(String title) {
        this(title, "Unknown Artist", 0);  // this()로 다른 생성자 호출
    }

    @Override
    public void play() {
        System.out.println("MP3 형식의 '" + getTitle() + "'이(가) 디지털로 재생됩니다.");
        System.out.println("현재 볼륨: " + volume);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("파일 크기: " + fileSize + "MB");
    }

    @Override
    public void setVolume(int level) {
        this.volume = level;
        System.out.println("볼륨이 " + level + "로 설정되었습니다.");
    }

    @Override
    public void stop() {
        System.out.println("MP3 재생이 중지되었습니다.");
    }
}
