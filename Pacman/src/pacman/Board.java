package pacman;

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

public class Board {

	public static final Color CANVAS_BACKGROUND = Color.black; // color of game background

	// drawing of pacman walls, borders, etc
	public final BufferedImage backgroundImage = GraphicsOptions.resize(GraphicsOptions.assets.image_background,
			(int) DrawCanvas.GAME_SIZE.getWidth(), (int) DrawCanvas.GAME_SIZE.getHeight() - 30);

	public ArrayList<int[]> hiddenDots = new ArrayList<int[]>();

	// intersection points: each point in each array is an intersection where the
	// direction in the name of the array is available
	public final int[][] leftPoints = { { 79, 584 }, { 79, 650 }, { 144, 105 }, { 144, 192 }, { 144, 257 },
			{ 144, 388 }, { 144, 520 }, { 144, 650 }, { 210, 192 }, { 210, 388 }, { 210, 520 }, { 210, 584 },
			{ 275, 105 }, { 275, 192 }, { 275, 257 }, { 275, 323 }, { 275, 454 }, { 275, 520 }, { 275, 584 },
			{ 275, 650 }, { 275, 715 }, { 340, 192 }, { 340, 323 }, { 340, 454 }, { 340, 584 }, { 340, 715 },
			{ 406, 192 }, { 406, 257 }, { 406, 323 }, { 406, 454 }, { 406, 520 }, { 406, 584 }, { 406, 650 },
			{ 471, 105 }, { 471, 192 }, { 471, 388 }, { 471, 520 }, { 471, 584 }, { 536, 650 }, { 580, 105 },
			{ 580, 192 }, { 580, 257 }, { 580, 520 }, { 580, 584 }, { 580, 650 }, { 580, 715 }, { 307, 323 },
			{ 307, 388 }, { 350, 388 } };

	public final int[][] rightPoints = { { 536, 584 }, { 536, 650 }, { 471, 105 }, { 471, 192 }, { 471, 257 },
			{ 471, 388 }, { 471, 520 }, { 471, 650 }, { 406, 192 }, { 406, 388 }, { 406, 520 }, { 406, 584 },
			{ 340, 105 }, { 340, 192 }, { 340, 257 }, { 340, 323 }, { 340, 454 }, { 340, 520 }, { 340, 584 },
			{ 340, 650 }, { 340, 715 }, { 275, 192 }, { 275, 323 }, { 275, 454 }, { 275, 584 }, { 275, 715 },
			{ 210, 192 }, { 210, 257 }, { 210, 323 }, { 210, 454 }, { 210, 520 }, { 210, 584 }, { 210, 650 },
			{ 144, 105 }, { 144, 192 }, { 144, 388 }, { 144, 520 }, { 144, 584 }, { 79, 650 }, { 35, 105 }, { 35, 192 },
			{ 35, 257 }, { 35, 520 }, { 35, 584 }, { 35, 650 }, { 35, 715 }, { 307, 323 }, { 307, 388 }, { 264, 388 } };

	public final int[][] upPoints = { { 35, 192 }, { 144, 192 }, { 275, 192 }, { 340, 192 }, { 471, 192 }, { 580, 192 },
			{ 35, 257 }, { 144, 257 }, { 210, 257 }, { 406, 257 }, { 471, 257 }, { 580, 257 }, { 275, 323 },
			{ 340, 323 }, { 144, 388 }, { 210, 388 }, { 406, 388 }, { 471, 388 }, { 210, 454 }, { 406, 454 },
			{ 144, 520 }, { 210, 520 }, { 406, 520 }, { 471, 520 }, { 35, 584 }, { 144, 584 }, { 275, 584 },
			{ 340, 584 }, { 471, 584 }, { 580, 584 }, { 79, 650 }, { 144, 650 }, { 210, 650 }, { 406, 650 },
			{ 471, 650 }, { 536, 650 }, { 35, 715 }, { 275, 715 }, { 340, 715 }, { 580, 715 }, { 307, 388 } };

	public final int[][] downPoints = { { 35, 105 }, { 144, 105 }, { 275, 105 }, { 340, 105 }, { 471, 105 },
			{ 580, 105 }, { 35, 192 }, { 144, 192 }, { 210, 192 }, { 406, 192 }, { 471, 192 }, { 580, 192 },
			{ 144, 257 }, { 275, 257 }, { 340, 257 }, { 471, 257 }, { 210, 323 }, { 406, 323 }, { 144, 388 },
			{ 210, 388 }, { 406, 388 }, { 471, 388 }, { 210, 454 }, { 406, 454 }, { 35, 520 }, { 144, 520 },
			{ 275, 520 }, { 340, 520 }, { 471, 520 }, { 580, 520 }, { 79, 584 }, { 144, 584 }, { 210, 584 },
			{ 406, 584 }, { 471, 584 }, { 536, 584 }, { 35, 650 }, { 275, 650 }, { 340, 650 }, { 580, 650 } };

	public final int[][] dots = { { 35, 105 }, { 57, 105 }, { 79, 105 }, { 101, 105 }, { 123, 105 }, { 144, 105 },
			{ 166, 105 }, { 188, 105 }, { 210, 105 }, { 232, 105 }, { 254, 105 }, { 275, 105 }, { 340, 105 },
			{ 362, 105 }, { 384, 105 }, { 406, 105 }, { 427, 105 }, { 449, 105 }, { 471, 105 }, { 492, 105 },
			{ 514, 105 }, { 536, 105 }, { 558, 105 }, { 580, 105 }, { 35, 127 }, /* { 35, 149 }, */ { 35, 170 },
			{ 144, 127 }, { 144, 149 }, { 144, 170 }, { 275, 127 }, { 275, 149 }, { 275, 170 }, { 340, 127 },
			{ 340, 149 }, { 340, 170 }, { 471, 127 }, { 471, 149 }, { 471, 170 }, { 580, 127 },
			/* { 580, 149 }, */ { 580, 170 }, { 35, 192 }, { 57, 192 }, { 79, 192 }, { 101, 192 }, { 123, 192 },
			{ 144, 192 }, { 166, 192 }, { 188, 192 }, { 210, 192 }, { 232, 192 }, { 254, 192 }, { 275, 192 },
			{ 297, 192 }, { 319, 192 }, { 340, 192 }, { 362, 192 }, { 384, 192 }, { 406, 192 }, { 427, 192 },
			{ 449, 192 }, { 471, 192 }, { 492, 192 }, { 514, 192 }, { 536, 192 }, { 558, 192 }, { 580, 192 },
			{ 35, 214 }, { 35, 235 }, { 144, 214 }, { 144, 235 }, { 210, 214 }, { 210, 235 }, { 406, 214 },
			{ 406, 235 }, { 471, 214 }, { 471, 235 }, { 580, 214 }, { 580, 235 }, { 35, 257 }, { 57, 257 }, { 79, 257 },
			{ 101, 257 }, { 123, 257 }, { 144, 257 }, { 210, 257 }, { 232, 257 }, { 254, 257 }, { 275, 257 },
			{ 340, 257 }, { 362, 257 }, { 384, 257 }, { 406, 257 }, { 471, 257 }, { 492, 257 }, { 514, 257 },
			{ 536, 257 }, { 558, 257 }, { 580, 257 }, { 144, 279 }, { 144, 301 }, { 471, 279 }, { 471, 301 },
			{ 144, 323 }, { 471, 323 }, { 144, 345 }, { 144, 366 }, { 471, 345 }, { 471, 366 }, { 144, 388 },
			{ 471, 388 }, { 144, 410 }, { 144, 432 }, { 471, 410 }, { 471, 432 }, { 144, 454 }, { 471, 454 },
			{ 144, 476 }, { 144, 498 }, { 471, 476 }, { 471, 498 }, { 35, 520 }, { 57, 520 }, { 79, 520 }, { 101, 520 },
			{ 123, 520 }, { 144, 520 }, { 166, 520 }, { 188, 520 }, { 210, 520 }, { 232, 520 }, { 254, 520 },
			{ 275, 520 }, { 340, 520 }, { 362, 520 }, { 384, 520 }, { 406, 520 }, { 427, 520 }, { 449, 520 },
			{ 471, 520 }, { 492, 520 }, { 514, 520 }, { 536, 520 }, { 558, 520 }, { 580, 520 }, { 35, 541 },
			{ 35, 563 }, { 144, 541 }, { 144, 563 }, { 275, 541 }, { 275, 563 }, { 340, 541 }, { 340, 563 },
			{ 471, 541 }, { 471, 563 }, { 580, 541 }, { 580, 563 }, /* { 35, 584 }, */ { 57, 584 }, { 79, 584 },
			{ 144, 584 }, { 166, 584 }, { 188, 584 }, { 210, 584 }, { 232, 584 }, { 254, 584 }, { 275, 584 },
			{ 340, 584 }, { 362, 584 }, { 384, 584 }, { 406, 584 }, { 427, 584 }, { 449, 584 }, { 471, 584 },
			{ 536, 584 }, { 558, 584 }, /* { 580, 584 }, */ { 79, 606 }, { 79, 628 }, { 144, 606 }, { 144, 628 },
			{ 210, 606 }, { 210, 628 }, { 406, 606 }, { 406, 628 }, { 471, 606 }, { 471, 628 }, { 536, 606 },
			{ 536, 628 }, { 35, 650 }, { 57, 650 }, { 79, 650 }, { 101, 650 }, { 123, 650 }, { 144, 650 }, { 210, 650 },
			{ 232, 650 }, { 254, 650 }, { 275, 650 }, { 340, 650 }, { 362, 650 }, { 384, 650 }, { 406, 650 },
			{ 471, 650 }, { 492, 650 }, { 514, 650 }, { 536, 650 }, { 558, 650 }, { 580, 650 }, { 35, 672 },
			{ 35, 693 }, { 275, 672 }, { 275, 693 }, { 340, 672 }, { 340, 693 }, { 580, 672 }, { 580, 693 },
			{ 35, 715 }, { 57, 715 }, { 79, 715 }, { 101, 715 }, { 123, 715 }, { 144, 715 }, { 166, 715 }, { 188, 715 },
			{ 210, 715 }, { 232, 715 }, { 254, 715 }, { 275, 715 }, { 297, 715 }, { 319, 715 }, { 340, 715 },
			{ 362, 715 }, { 384, 715 }, { 406, 715 }, { 427, 715 }, { 449, 715 }, { 471, 715 }, { 492, 715 },
			{ 514, 715 }, { 536, 715 }, { 558, 715 }, { 580, 715 } };

	public final int[][] largeDots = { { 35, 149 }, { 580, 149 }, { 35, 584 }, { 580, 584 } };

	public void checkReset() {
		if (dots.length + largeDots.length == hiddenDots.size()) {
			hiddenDots = new ArrayList<int[]>();
		}
	}
}