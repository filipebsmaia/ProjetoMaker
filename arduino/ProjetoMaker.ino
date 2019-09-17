#include <Adafruit_NeoPixel.h>

#define P1_UP 4
#define P1_DOWN 5
#define P1_RIGHT 6
#define P1_LEFT 7
#define P1_ACTION 8

#define P1_PIN_X A4
#define P1_PIN_Y A5

#define P2_PIN_X A2
#define P2_PIN_Y A1

#define P2_UP 9
#define P2_DOWN 10
#define P2_RIGHT 11
#define P2_LEFT 12
#define P2_ACTION 13

#define LED_PIN 2

#define LED_COLUMNS 10
#define LED_ROWS 10

bool P1_ATTACK;
int P1_KEY;

bool P2_ATTACK;
int P2_KEY;

bool inGame;

String game = "none";
String next = "none";

Adafruit_NeoPixel strip(LED_COLUMNS * LED_ROWS, LED_PIN, NEO_GRB + NEO_KHZ800);

void flushStrip() {
	for (int i = 0; i <= LED_COLUMNS * LED_ROWS; i++) {
		strip.setPixelColor(i, strip.Color(0, 0, 0));
	}
}

void setStripColor(int r, int g, int b) {
	for (int i = 0; i <= LED_COLUMNS * LED_ROWS; i++) {
		strip.setPixelColor(i, strip.Color(r, g, b));
	}
}

int rnd() {
	return random(0, 255);
}

void setup() {
	Serial.begin(9600);
	randomSeed(analogRead(0));
	// put your setup code here, to run once:
//	pinMode(P1_UP, OUTPUT);
//	pinMode(P1_DOWN, OUTPUT);
//	pinMode(P1_RIGHT, OUTPUT);
//	pinMode(P1_LEFT, OUTPUT);
//	pinMode(P1_ACTION, OUTPUT);
//	pinMode(P1_ACTION, OUTPUT);
//
//	pinMode(P2_UP, OUTPUT);
//	pinMode(P2_DOWN, OUTPUT);
//	pinMode(P2_RIGHT, OUTPUT);
//	pinMode(P2_LEFT, OUTPUT);
//	pinMode(P2_ACTION, OUTPUT);

	pinMode(P1_PIN_X, INPUT);
	pinMode(P1_PIN_Y, INPUT);


	pinMode(P2_PIN_X, INPUT);
	pinMode(P2_PIN_Y, INPUT);

	strip.begin();
	strip.setBrightness(5);
	//setStripColor(50, 100, 150);
	strip.show();
	delay(250);
	Serial.println("Ready.");
	game = "idle";
	next = "idle";

}

void loop() {

	if(Serial.available() > 0) {
		Serial.println("Receided:");
	    String command = getReceived();
		Serial.println(command);
	    if(command.equalsIgnoreCase("Game: Snake")){
	    	next = "snake";
	    }
	    if(command.equalsIgnoreCase("Game: Pong")){
	    	next = "pong";
	    }
	    if(command.equalsIgnoreCase("Game: Idle")){
	    	next = "idle";
	    }
	}
	if(!inGame) {
		game = next;
	}

	if (!inGame && game.equals("snake")) {
		delay(1000);
		snake();
	} else if (!inGame && game.equals("pong")) {
		pong();
	} else if (!inGame && game.equals("idle")) {
		idle();
		Serial.println("Running idle");
	}

	if (digitalRead(P1_ACTION) == HIGH) {
		P1_ATTACK = true;
	} else {
		P1_ATTACK = false;
	}
	int x = analogRead(P1_PIN_X);
	int y = analogRead(P1_PIN_Y);
//	delay(250);
//	Serial.print("x ");
//	Serial.print(+x);
//	Serial.print("    ");
//	Serial.print("y ");
//	Serial.println(y);
	if (y < 400) {
		P1_KEY = 1;
	} else if (y > 600) {
		P1_KEY = 2;
	} else if (x < 400) {
		P1_KEY = 3;
	} else if (x > 600) {
		P1_KEY = 4;
	}

	x = analogRead(P2_PIN_X);
	y = analogRead(P2_PIN_Y);

	if (y < 400) {
		P1_KEY = 2;
	} else if (y > 600) {
		P1_KEY = 1;
	} else if (x < 400) {
		P1_KEY = 4;
	} else if (x > 600) {
		P1_KEY = 3;
	}

//	if (digitalRead(P2_ACTION) == HIGH) {
//		P2_ATTACK = true;
//	} else {
//		P2_ATTACK = false;
//	}
//	if (digitalRead(P2_UP) == HIGH) {
//		P2_KEY = 1;
//	} else if (digitalRead(P2_DOWN) == HIGH) {
//		P2_KEY = 2;
//	} else if (digitalRead(P2_RIGHT) == HIGH) {
//		P2_KEY = 3;
//	} else if (digitalRead(P2_LEFT) == HIGH) {
//		P2_KEY = 4;
//	}

	if (inGame) {
		if (game.equals("snake")) {
			snakeRun();
		} else if (game.equals("pong")) {
			pongRun();

		}
	}
	strip.show();
}

//TODO IDLE

int idle_r = 255, idle_g, idle_b = 255;
int dlay = 5;
long idle_last;
void idle() {
	for (int g = 0; g < 255; g = g + 1) {
		idle_g = g;
		if(Serial.available() <= 0) {
			setStripColor(idle_r, idle_g, idle_b);
			strip.show();
			delay(dlay);
		}
	}
	for (int r = 255; r > 0; r = r - 1) {
		idle_r = r;
		if(Serial.available() <= 0) {
			setStripColor(idle_r, idle_g, idle_b);
			strip.show();
			delay(dlay);
		}
	}
	for (int b = 0; b < 255; b = b + 1) {
		idle_b = b;
		if(Serial.available() <= 0) {
			setStripColor(idle_r, idle_g, idle_b);
			strip.show();
			delay(dlay);
		}
	}

	for (int g = 255; g > 0; g = g - 1) {
		idle_g = g;
		if(Serial.available() <= 0) {
			setStripColor(idle_r, idle_g, idle_b);
			strip.show();
			delay(dlay);
		}
	}
	for (int r = 0; r < 255; r = r + 1) {
		idle_r = r;
		if(Serial.available() <= 0) {
			setStripColor(idle_r, idle_g, idle_b);
			strip.show();
			delay(dlay);
		}
	}
	for (int b = 255; b > 0; b = b - 1) {
		idle_b = b;
		if(Serial.available() <= 0) {
			setStripColor(idle_r, idle_g, idle_b);
			strip.show();
			delay(dlay);
		}
	}
}

//TODO START OF PONG GAME

int pong_ball_x;
int pong_ball_y;

int pong_ball_direction_x;
int pong_ball_direction_y;

int pong_p1_paddle;
int pong_p1_paddle_size;
int pong_p2_paddle;
int pong_p2_paddle_size;

int pong_touch;

void pong(){
	inGame = true;
	P1_KEY = 0;
	P2_KEY = 0;

	pong_p1_paddle = LED_COLUMNS / 2;
	pong_p1_paddle_size = 1;

	pong_p2_paddle = LED_COLUMNS / 2;
	pong_p2_paddle_size = 1;

	pong_ball_x =  LED_COLUMNS/ 2;
	pong_ball_y = LED_ROWS / 2;
	pong_touch = 0;
	pongDraw();
}

long ball_last;
long move_last;

void pongRun(){
	long now = millis();
	if (ball_last + 150 - pong_touch < now) {
		ball_last = now;
		pongBall();
		pongDraw();
	}
	if (move_last + 250 < now) {
		move_last = now;
		pongMove();
		pongDraw();
	}
}

void pongMove(){
	if (!inGame) {
		return;
	}

	switch (P1_KEY) {
		case 3: {
			if(pong_p1_paddle < 9 - pong_p1_paddle_size){
				pong_p1_paddle++;
			}
			Serial.print("3 ");
			Serial.println(pong_p1_paddle);
			break;
		}
		case 4: {
			if(pong_p1_paddle > pong_p1_paddle_size){
				pong_p1_paddle--;
			}
			break;
		}
	}



	P1_KEY = 0;
	P2_KEY = 0;
}

void pongBall(){
	if(pong_ball_direction_y == 0){
		pong_ball_direction_y = 1;
	}

	//CHECAR PAREDE
	if(pong_ball_x == 1){
		pong_ball_direction_x = 1;
	} else if(pong_ball_x == LED_COLUMNS){
		pong_ball_direction_x = -1;
	}


	if(pong_ball_direction_x > 0){
		pong_ball_x++;
	} else if(pong_ball_direction_x < 0){
		pong_ball_x--;
	}

	if(pong_ball_direction_y < 0){
		pong_ball_y++;
	} else if(pong_ball_direction_y > 0){
		pong_ball_y--;
	}

	if(pong_ball_y == 0) {
		for(int i = -pong_p1_paddle_size; i <= pong_p1_paddle_size; i ++){
			int paddle = pong_p1_paddle + i;
			Serial.print(pong_ball_x);
			Serial.print(" ");
			Serial.println(paddle);
			if(paddle == pong_ball_x) {
				Serial.print("HIT AT ");
				Serial.println(paddle);
				pong_ball_direction_y = -1;
				if(i > 0) {
					pong_ball_direction_x++;
				} else if (i < 0){
					pong_ball_direction_x--;
				}
				pong_touch+= 4;
				pongBall();
				pongBall();
				break;
			}
		}
	} else if(pong_ball_y == LED_ROWS - 1) {
		for(int i = -pong_p2_paddle_size; i <= pong_p2_paddle_size; i ++){
			int paddle = pong_p2_paddle + i;
			if(paddle == pong_ball_x) {
				pong_ball_direction_y = 1;
				if(i > 0) {
					pong_ball_direction_x++;
				} else if (i < 0){
					pong_ball_direction_x--;
				}
				pong_touch+= 4;
				pongBall();
				pongBall();
				break;
			}
		}
	}
	if(pong_ball_y < 0){
		delay(2000);
		pong_ball_x =  LED_COLUMNS/ 2;
		pong_ball_y = LED_ROWS / 2;
		pong_ball_direction_y = -1;
		pong_ball_direction_x = 0;
		inGame = false;
	} else if (pong_ball_y > LED_COLUMNS) {
		delay(2000);
		pong_ball_x =  LED_COLUMNS/ 2;
		pong_ball_y = LED_ROWS / 2;
		pong_ball_direction_y = 1;
		pong_ball_direction_x = 0;
		pong_touch = 0;
		inGame = false;
	}
}

void pongDraw(){
	flushStrip();

	int ball = (pong_ball_y * LED_COLUMNS) + pong_ball_x - 1;
	strip.setPixelColor(ball, strip.Color(0, 0, 255));

	for(int i = -pong_p1_paddle_size; i <= pong_p1_paddle_size; i ++){
		int paddle = pong_p1_paddle + i - 1;
		strip.setPixelColor(paddle, strip.Color(255, 0, 0));
	}

	for(int i = -pong_p2_paddle_size; i <= pong_p2_paddle_size; i ++){
		int paddle = pong_p2_paddle + i + ((LED_ROWS - 1) * LED_COLUMNS) - 1;
		strip.setPixelColor(paddle, strip.Color(0, 255, 0));
	}

	strip.show();
}



//TODO END OF PONG GAME

//TODO START OF SNAKE GAME
int snake_x[60];
int snake_y[60];
int snake_dots = 3;
int snake_apple_x;
int snake_apple_y;

void snake() {
	inGame = true;
	snake_dots = 3;
	P1_KEY = 3;

	for (int z = 0; z < snake_dots; z++) {
		snake_x[z] = 3 - z;
		snake_y[z] = 3;
	}

	snakeSpawnApple();
	snakeDraw();
	snakeBorderCount();

}

long snake_last;
void snakeRun(){
	long now = millis();
	if (snake_last + 150 - snake_dots < now) {
		snake_last = millis();
		snakeMove();

		snakeCheckApple();

		snakeCheckCollision();

		snakeDraw();

		Serial.print("Total time: ");
		Serial.println((now - millis()));
	}

}

void snakeBorderCount() {
	delay(1000);
	for (int i = 0; i < LED_COLUMNS; i++) {
		strip.setPixelColor(i, strip.Color(255, 0, 0));
		strip.setPixelColor(LED_COLUMNS * (LED_ROWS - 1) + i,
				strip.Color(255, 0, 0));
	}
	for (int i = 0; i < LED_ROWS; i++) {
		strip.setPixelColor(i * LED_COLUMNS, strip.Color(255, 0, 0));
		strip.setPixelColor(i * LED_COLUMNS + LED_COLUMNS - 1,
				strip.Color(255, 0, 0));
	}
	strip.show();
	delay(1000);

	for (int i = 0; i < LED_COLUMNS; i++) {
		strip.setPixelColor(i, strip.Color(255, 255, 0));
		strip.setPixelColor(LED_COLUMNS * (LED_ROWS - 1) + i,
				strip.Color(255, 255, 0));
	}
	for (int i = 0; i < LED_ROWS; i++) {
		strip.setPixelColor(i * LED_COLUMNS, strip.Color(255, 255, 0));
		strip.setPixelColor(i * LED_COLUMNS + LED_COLUMNS - 1,
				strip.Color(255, 255, 0));
	}
	strip.show();
	delay(1000);

	for (int i = 0; i < LED_COLUMNS; i++) {
		strip.setPixelColor(i, strip.Color(0, 255, 0));
		strip.setPixelColor(LED_COLUMNS * (LED_ROWS - 1) + i,
				strip.Color(0, 255, 0));
	}
	for (int i = 0; i < LED_ROWS; i++) {
		strip.setPixelColor(i * LED_COLUMNS, strip.Color(0, 255, 0));
		strip.setPixelColor(i * LED_COLUMNS + LED_COLUMNS - 1,
				strip.Color(0, 255, 0));
	}
	strip.show();
	delay(1000);
}

void snakeMove() {
	if (!inGame) {
		return;
	}
	for (int z = snake_dots; z > 0; z--) {
		snake_x[z] = snake_x[(z - 1)];
		snake_y[z] = snake_y[(z - 1)];
	}

	switch (P1_KEY) {
		case 1: {
			snake_y[0]--;
			break;
		}
		case 3: {
			snake_x[0]++;
			break;
		}
		case 2: {
			snake_y[0]++;
			break;
		}
		case 4: {
			snake_x[0]--;
			break;
		}
	}
}

void snakeCheckCollision() {
	if (!inGame) {
		return;
	}
	Serial.println(snake_x[0]);
	Serial.println(snake_y[0]);
	Serial.println("-----");
	if (snake_x[0] >= LED_COLUMNS - 1) {
		inGame = false;
	} else if (snake_x[0] <= 0) {
		inGame = false;
	} else if (snake_y[0] >= LED_ROWS - 1) {
		inGame = false;
	} else if (snake_y[0] <= 0) {
		inGame = false;
	} else {
		for (int z = snake_dots; z > 0; z--) {
			if ((z > 3) && (snake_x[0] == snake_x[z])
					&& (snake_y[0] == snake_y[z])) {
				inGame = false;
			}
		}
	}
	if (!inGame) {
		Serial.println("Die");
		delay(1000);
		for (int i = 0; i <= 7; i++) {
			setStripColor(255, 0, 0);
			delay(100);
			strip.show();
			setStripColor(0, 0, 0);
			delay(100);
			strip.show();
		}
	}
}

void snakeSpawnApple() {
	snake_apple_x = random(0, LED_COLUMNS - 2) + 1;
	snake_apple_y = random(0, LED_ROWS - 2) + 1;

	for (int z = snake_dots; z > 0; z--) {
		if (snake_apple_x == snake_x[z]) {
			if (snake_apple_y == snake_y[z]) {
				snakeSpawnApple();
			}
		}
	}
}

void snakeCheckApple() {
	if (snake_x[0] == snake_apple_x) {
		if (snake_y[0] == snake_apple_y) {
			snake_dots++;
			snakeSpawnApple();
		}
	}
}

void snakeDraw() {
	if (!inGame) {
		return;
	}
	flushStrip();
	for (int i = 0; i < LED_COLUMNS; i++) {
		strip.setPixelColor(i, strip.Color(255, 0, 0));
		strip.setPixelColor(LED_COLUMNS * (LED_ROWS - 1) + i,
				strip.Color(255, 0, 0));
	}
	for (int i = 0; i < LED_ROWS; i++) {
		strip.setPixelColor(i * LED_COLUMNS, strip.Color(255, 0, 0));
		strip.setPixelColor(i * LED_COLUMNS + LED_COLUMNS - 1,
				strip.Color(255, 0, 0));
	}

	int apple = (snake_apple_y * LED_COLUMNS) + (snake_apple_x);
	strip.setPixelColor(apple, strip.Color(0, 255, 0));
	for (int z = 0; z < snake_dots; z++) {
		int led = snake_y[z] * LED_COLUMNS + snake_x[z];
		if (z == 0) { // HEAD
			strip.setPixelColor(led, strip.Color(200, 255, 0));
		} else {
			strip.setPixelColor(led, strip.Color(0, 200, 255));
		}
	}
}
//TODO END OF SNAKE GAME

String getReceived() {
	String r = "";
	while (Serial.available()) {
		delay(2);
		char c = Serial.read();
		if (c == ';') {
			break;
		}
		r += c;
	}
	return r;
}
