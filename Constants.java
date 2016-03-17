public interface Constants {

		//Menu variables
	String MENU_KEY = "menu";
	String GAME_KEY = "game";
	String LOADING_KEY = "loading";
	String OPTIONS_KEY = "options";
	String EFFECTS_PATH = "resources\\soundFX\\";
	String MUSIC_PATH = "resources\\music\\";
	String PICTURES_PATH = "resources\\pictures\\";
	
	    //Program variables
    int BLOCK_SIZE = 32;
    int TARGET_FPS = 60; //Number of different frames drawn per second
    int CALCULATIONS_PER_SECOND = 60; //Number of times the objects are updated each second

    //Gameplay variables
    int HORIZONTAL_MOVEMENT_SPEED = 2; //Player speed
    int VERTICAL_MOVEMENT_SPEED = 4; //Player speed
    int WORLD_SIZE_X = BLOCK_SIZE * 150;
    int WORLD_SIZE_Y = BLOCK_SIZE * 150;

    //Viewport size
    int WIDTH = BLOCK_SIZE * 150;
    int HEIGHT = BLOCK_SIZE * 150;

    //Side-scrolling camera settings
    int OFFSET_MAX_X = WORLD_SIZE_X - WIDTH;
    int OFFSET_MAX_Y = WORLD_SIZE_Y - HEIGHT;
    int OFFSET_MIN_X = 0;
    int OFFSET_MIN_Y = 0;
}