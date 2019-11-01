using System;

using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Storage;
using Microsoft.Xna.Framework.Input;
using System.Collections.Generic;

namespace four
{
	/// <summary>
	/// This is the code for a solitaire game, 
	/// the code is not 100% complete, but it 
	/// gets the basic job done.
	/// </summary>
	public class Game1 : Game
	/// <summary>
	/// Below is where I initialize the rectangles for the various cards
	/// and for the various pile locations, I also initialize the various lists
	/// for the stacks of cards as well as the booleans which change based on 
	/// whether or not the card selected is changing location.
	/// </summary>
	{
		GraphicsDeviceManager graphics;
		SpriteBatch spriteBatch;
		SpriteFont font;
		Texture2D playingCards;
		Texture2D blackSlot;
		Rectangle twoOfHearts;
		Rectangle threeOfHearts;
		Rectangle fourOfHearts;
		Rectangle fiveOfHearts;
		Rectangle sixOfHearts;
		Rectangle sevenOfHearts;
		Rectangle eightOfHearts;
		Rectangle nineOfHearts;
		Rectangle tenOfHearts;
		Rectangle jackOfHearts;
		Rectangle queenOfHearts;
		Rectangle kingOfHearts;
		Rectangle aceOfHearts;
		Rectangle twoOfDiamonds;
		Rectangle threeOfDiamonds;
		Rectangle fourOfDiamonds;
		Rectangle fiveOfDiamonds;
		Rectangle sixOfDiamonds;
		Rectangle sevenOfDiamonds;
		Rectangle eightOfDiamonds;
		Rectangle nineOfDiamonds;
		Rectangle tenOfDiamonds;
		Rectangle jackOfDiamonds;
		Rectangle queenOfDiamonds;
		Rectangle kingOfDiamonds;
		Rectangle aceOfDiamonds;
		Rectangle twoOfClubs;
		Rectangle threeOfClubs;
		Rectangle fourOfClubs;
		Rectangle fiveOfClubs;
		Rectangle sixOfClubs;
		Rectangle sevenOfClubs;
		Rectangle eightOfClubs;
		Rectangle nineOfClubs;
		Rectangle tenOfClubs;
		Rectangle jackOfClubs;
		Rectangle queenOfClubs;
		Rectangle kingOfClubs;
		Rectangle aceOfClubs;
		Rectangle twoOfSpades;
		Rectangle threeOfSpades;
		Rectangle fourOfSpades;
		Rectangle fiveOfSpades;
		Rectangle sixOfSpades;
		Rectangle sevenOfSpades;
		Rectangle eightOfSpades;
		Rectangle nineOfSpades;
		Rectangle tenOfSpades;
		Rectangle jackOfSpades;
		Rectangle queenOfSpades;
		Rectangle kingOfSpades;
	    Rectangle aceOfSpades;
		Rectangle aceSlot1;
		Rectangle aceSlot2;
		Rectangle aceSlot3;
		Rectangle aceSlot4;
		Vector2 firstSlot1;
		Vector2 secondSlot1;
		Vector2 thirdSlot1;
		Vector2 fourthSlot1;
		Vector2 fifthSlot1;
		Vector2 sixthSlot1;
		Vector2 seventhSlot1;
		Vector2 eighthSlot1;
		Rectangle one;
		Rectangle two;
		Rectangle three;
		Rectangle four;
		Rectangle five;
		Rectangle six;
		Rectangle seven;
		Rectangle eight;
		Rectangle discard;
		Rectangle stackTopSection;
		Rectangle stack2TopSection;
		Rectangle stack2SecondSection;
		Rectangle stack3TopSection;
		Rectangle stack3SecondSection;
		Rectangle stack3ThirdSection;
		Rectangle stack4TopSection;
		Rectangle stack4SecondSection;
		Rectangle stack4ThirdSection;
		Rectangle stack4FourthSection;
		Rectangle stack5TopSection;
		Rectangle stack5SecondSection;
		Rectangle stack5ThirdSection;
		Rectangle stack5FourthSection;
		Rectangle stack5FifthSection;
		Rectangle stack6TopSection;
		Rectangle stack6SecondSection;
		Rectangle stack6ThirdSection;
		Rectangle stack6FourthSection;
		Rectangle stack6FifthSection;
		Rectangle stack6SixthSection;
		Rectangle stack7TopSection;
		Rectangle stack7SecondSection;
		Rectangle stack7ThirdSection;
		Rectangle stack7FourthSection;
		Rectangle stack7FifthSection;
		Rectangle stack7SixthSection;
		Rectangle stack7SeventhSection;
		int width = 81;
		int height = 118;
		MouseState current;
		cards[] deck = new cards[52]; 
		List<cards>stack;
		List<cards>stack2;
		List<cards>stack3;
		List<cards>stack4;
		List<cards>stack5;
		List<cards>stack6;
		List<cards>stack7;
		List<cards>aceOne;
		List<cards>aceTwo;
		List<cards>aceThree;
		List<cards>aceFour;
		List<cards>pile;
		List<cards>dealt;
	
		List<cards>movingCards;
		Boolean onCard1 = false;
		Boolean onCard2 = false;
		Boolean onCard3 = false;
		Boolean onCard4 = false;
		Boolean onCard5 = false;
		Boolean onCard6 = false;
		Boolean onCard7 = false;
		Boolean onCard8 = false;

		Vector2 movingLocation1;
		Vector2 movingLocation2;
		Vector2 movingLocation3;
		Vector2 movingLocation4;
		Vector2 movingLocation5;
		Vector2 movingLocation6;
		Vector2 movingLocation7;
		Vector2 pileLocation;
		Boolean moving1 = false;
		Boolean moving2 = false; 
		Boolean moving3 = false;
		Boolean moving4 = false;
		Boolean moving5 = false;
		Boolean moving6 = false;
		Boolean moving7 = false;
		Boolean moving8 = false;
		Boolean movingMult1 = false;
		Boolean movingMult2 = false; 
		Boolean movingMult3 = false;
		Boolean movingMult4 = false;
		Boolean movingMult5 = false;
		Boolean movingMult6 = false;
		Boolean movingMult7 = false;
		// These integers act as a counter for the respective "Final Slots," 
		// and will increment by one as cards are added to the them.
		int aceSlotOne = 1;
		int aceSlotTwo = 1;
		int aceSlotThree = 1;
		int aceSlotFour = 1;
		public Game1 ()

		{
			graphics = new GraphicsDeviceManager (this);
			Content.RootDirectory = "Content";
			// The following are booleans which will allow 
			// both the mouse to be used and for the game to 
			// be displayed in full screen.
			IsMouseVisible = true;
			graphics.IsFullScreen = true;
		}

		/// <summary>
		/// Allows the game to perform any initialization it needs to before starting to run.
		/// This is where it can query for any required services and load any non-graphic
		/// related content.  Calling base.Initialize will enumerate through any components
		/// and initialize them as well.
		/// </summary>
		protected override void Initialize ()
		{
			// TODO: Add your initialization logic here
			// For variables that are not int's and booleans, we further
			// define what they are below. In addition we add each individual card into 
			// the various stacks by using the .Add method

			cards ();
			//The method below will go through the cards where they start and shuffle them around
			//so their location is different everytime you play.
			shuffle();
			base.Initialize ();
			stack = new List<cards> ();
			stack2 = new List<cards> ();
			stack3 = new List<cards> ();
			stack4 = new List<cards> ();
			stack5 = new List<cards> ();
			stack6 = new List<cards> ();
			stack7 = new List<cards> ();
			pile = new List<cards> ();
			aceOne = new List<cards> ();
			aceTwo = new List<cards> ();
			aceThree = new List<cards> ();
			aceFour = new List<cards> ();
			dealt = new List<cards> ();
		
			movingCards = new List<cards> ();
			deck[0].flip();
			stack.Add (deck [0]);
			stack2.Add (deck [1]);
			deck [2].flip ();
			stack2.Add (deck [2]);
			stack3.Add (deck [3]);
			stack3.Add (deck [4]);
			deck [5].flip ();
			stack3.Add (deck [5]);
			stack4.Add (deck [6]);
			stack4.Add (deck [7]);
			stack4.Add (deck [8]);
			deck [9].flip ();
			stack4.Add (deck [9]);
			stack5.Add (deck [10]);
			stack5.Add (deck [11]);
			stack5.Add (deck [12]);
			stack5.Add (deck [13]);
			deck [14].flip ();
			stack5.Add (deck [14]);
			stack6.Add (deck [15]);
			stack6.Add (deck [16]);
			stack6.Add (deck [17]);
			stack6.Add (deck [18]);
			stack6.Add (deck [19]);
			deck [20].flip ();
			stack6.Add (deck [20]);
			stack7.Add (deck [21]);
			stack7.Add (deck [22]);
			stack7.Add (deck [23]);
			stack7.Add (deck [24]);
			stack7.Add (deck [25]);
			stack7.Add (deck [26]);
			deck [27].flip ();
			stack7.Add (deck [27]);
			pile.Add (deck [28]);
			pile.Add (deck [29]);
			pile.Add (deck [30]);
			pile.Add (deck [31]);
			pile.Add (deck [32]);
			pile.Add (deck [33]);
			pile.Add (deck [34]);
			pile.Add (deck [35]);
			pile.Add (deck [36]);
			pile.Add (deck [37]);
			pile.Add (deck [38]);
			pile.Add (deck [39]);
			pile.Add (deck [40]);
			pile.Add (deck [41]);
			pile.Add (deck [42]);
			pile.Add (deck [43]);
			pile.Add (deck [44]);
			pile.Add (deck [45]);
			pile.Add (deck [46]);
			pile.Add (deck [47]);
			pile.Add (deck [48]);
			pile.Add (deck [49]);
			pile.Add (deck [50]);
			pile.Add (deck [51]);

	}

		/// <summary>
		/// LoadContent will be called once per game and is the place to load
		/// all of your content.
		/// </summary>
		protected override void LoadContent ()
		{
			// Create a new SpriteBatch, which can be used to draw textures.
			spriteBatch = new SpriteBatch (GraphicsDevice);
			playingCards = Content.Load<Texture2D> ("playingcards3");
			font = Content.Load<SpriteFont> ("font");
			blackSlot = Content.Load<Texture2D> ("aceSlot");


			//TODO: use this.Content to load your game content here 
		}

		/// <summary>
		/// Allows the game to run logic such as updating the world,
		/// checking for collisions, gathering input, and playing audio.
		/// </summary>
		/// <param name="gameTime">Provides a snapshot of timing values.</param>
		protected override void Update (GameTime gameTime)
		{
			// For Mobile devices, this logic will close the Game when the Back button is pressed
			// Exit() is obsolete on iOS
			//#if !__IOS__ &&  !__TVOS__
			if (GamePad.GetState (PlayerIndex.One).Buttons.Back == ButtonState.Pressed || Keyboard.GetState ().IsKeyDown (Keys.Escape))
				Exit ();
		
            // TODO: Add your update logic here
			// the follwing lines of code specifically define where
			// the various rectangles will be located as well as the 
			// initial location for the "moving locations."
			current = Mouse.GetState();
			movingLocation1 = new Vector2 (150, 200);
			movingLocation2 = new Vector2 (300, 200);
			movingLocation3 = new Vector2 (450, 200);
			movingLocation4 = new Vector2 (600, 200);
			movingLocation5 = new Vector2 (750, 200);
			movingLocation6 = new Vector2 (900, 200);
			movingLocation7 = new Vector2 (1050, 200);
			pileLocation = new Vector2 (400, 600);
			one = new Rectangle (150, 200, 81, 298);
			two = new Rectangle (300, 200, 81, 298); 
			three = new Rectangle (450, 200, 81, 298); 
			four = new Rectangle (600, 200, 81, 298); 
			five = new Rectangle (750, 200, 81, 298); 
			six = new Rectangle (900, 200, 81, 298); 
			seven = new Rectangle (1050, 200, 81, 298); 
			eight = new Rectangle (400, 600, 81, 118);
			discard = new Rectangle (550, 600, 81, 118);
			aceSlot1 = new Rectangle (150, 50, 81, 118);
			aceSlot2 = new Rectangle (300, 50, 81, 118);
			aceSlot3 = new Rectangle (450, 50, 81, 118);
			aceSlot4 = new Rectangle (600, 50, 81, 118);
			stackTopSection = new Rectangle (150, 200, 81, 30);
			stack2TopSection = new Rectangle (300, 200, 81, 30);
			stack2SecondSection = new Rectangle (300, 230, 81, 30);
			stack3TopSection = new Rectangle (450, 200, 81, 30);
			stack3SecondSection = new Rectangle (450, 230, 81, 30);
			stack3ThirdSection = new Rectangle (450, 260, 81, 30);
			stack4TopSection = new Rectangle (600, 200, 81, 30);
			stack4SecondSection = new Rectangle (600, 230, 81, 30);
			stack4ThirdSection = new Rectangle (600, 260, 81, 30);
			stack4FourthSection = new Rectangle (600, 290, 81, 30);
			stack5TopSection = new Rectangle (750, 200, 81, 30);
			stack5SecondSection = new Rectangle (750, 230, 81, 30);
			stack5ThirdSection = new Rectangle (750, 260, 81, 30);
			stack5FourthSection = new Rectangle (750, 290, 81, 30);
			stack5FifthSection = new Rectangle (750, 320, 81, 30);
			stack6TopSection = new Rectangle (900, 200, 81, 30);
			stack6SecondSection = new Rectangle (900, 230, 81, 30);
			stack6ThirdSection = new Rectangle (900, 260, 81, 30);
			stack6FourthSection = new Rectangle (900, 290, 81, 30);
			stack6FifthSection = new Rectangle (900, 320, 81, 30);
			stack6SixthSection = new Rectangle (900, 350, 81, 30);
			stack7TopSection = new Rectangle (1050, 200, 81, 30);
			stack7SecondSection = new Rectangle (1050, 230, 81, 30);
			stack7ThirdSection = new Rectangle (1050, 260, 81, 30);
			stack7FourthSection = new Rectangle (1050, 290, 81, 30);
			stack7FifthSection = new Rectangle (1050, 320, 81, 30);
			stack7SixthSection = new Rectangle (1050, 350, 81, 30);
			stack7SeventhSection = new Rectangle (1050, 380, 81, 30);
			base.Update (gameTime);
		}

		/// <summary>
		/// This is called when the game should draw itself.
		/// </summary>
		/// <param name="gameTime">Provides a snapshot of timing values.</param>
		protected override void Draw (GameTime gameTime)
		{
			//Below we draw stuff: some text to tell the user where the draw and discard piles are, 
			//we also draw just some blank white rectangles to be used as placement spots for the 
			// "final stacks."
			graphics.GraphicsDevice.Clear (Color.CornflowerBlue);
			spriteBatch.Begin();
			spriteBatch.DrawString (font, "Draw Pile", new Vector2 (410,750 ), Color.Black);
			spriteBatch.DrawString (font, "Discard Pile", new Vector2 (550,750 ), Color.Black);
			spriteBatch.Draw (blackSlot, new Vector2 (150, 50), Color.White);
			spriteBatch.Draw (blackSlot, new Vector2 (300, 50), Color.White);
			spriteBatch.Draw (blackSlot, new Vector2 (450, 50), Color.White);
			spriteBatch.Draw (blackSlot, new Vector2 (600, 50), Color.White);
			spriteBatch.Draw (blackSlot, new Vector2 (400, 600), Color.White);
			spriteBatch.Draw (blackSlot, new Vector2 (550, 600), Color.White);

			// Below we draw all of the stacks using a for loop which loops through the number of items in each stack and starts at zero
			// we draw them at their respective moving location but increment the Y value of that vector by i * 30 to give the cards
			// the spread effect that can be seen when you start the game
			for (int i = 0; i < stack.Count; i++) {
				cards c = (cards)stack [i];	
				spriteBatch.Draw (playingCards, new Vector2 (movingLocation1.X, movingLocation1.Y+i*30), c.getSource (), Color.White);
			}

			for (int i = 0; i < stack2.Count; i++) {

				cards c = (cards)stack2 [i];	
				spriteBatch.Draw (playingCards, new Vector2 (movingLocation2.X, movingLocation2.Y+i*30), c.getSource (), Color.White);
			}

			for (int i = 0; i < stack3.Count; i++) {

				cards c = (cards)stack3 [i];	
				spriteBatch.Draw (playingCards, new Vector2(movingLocation3.X, movingLocation3.Y+i*30), c.getSource (), Color.White);

			}

			for (int i = 0; i < stack4.Count; i++) {
				cards c = (cards)stack4 [i];	
				spriteBatch.Draw (playingCards, new Vector2(movingLocation4.X, movingLocation4.Y+i*30), c.getSource (), Color.White);

			}

			for (int i = 0; i < stack5.Count; i++) {
				cards c = (cards)stack5 [i];	
				spriteBatch.Draw (playingCards, new Vector2(movingLocation5.X, movingLocation5.Y+i*30), c.getSource (), Color.White);

			}

			for (int i = 0; i < stack6.Count; i++) {
				cards c = (cards)stack6 [i];	
				spriteBatch.Draw (playingCards, new Vector2(movingLocation6.X, movingLocation6.Y+i*30), c.getSource (), Color.White);

			}

			for (int i = 0; i < stack7.Count; i++) {
				cards c = (cards)stack7 [i];	
				spriteBatch.Draw (playingCards, new Vector2(movingLocation7.X, movingLocation7.Y+i*30), c.getSource (), Color.White);
			}
			for (int i = 0; i < pile.Count; i++) {
				cards c = (cards)pile [i];	
				spriteBatch.Draw (playingCards, new Vector2 (400, 600), c.getSource (), Color.White);
			}


			for (int i = 0; i < movingCards.Count; i++) {
				cards c = (cards)movingCards [i];
				spriteBatch.Draw (playingCards, new Vector2 (150,600+i*30), c.getSource (), Color.White);
			}


			for (int i = 0; i < aceOne.Count; i++) {
				cards c = (cards)aceOne [i];	
				spriteBatch.Draw (playingCards, new Vector2 (150, 50), c.getSource (), Color.White);
			}
			for (int i = 0; i < aceTwo.Count; i++) {
				cards c = (cards)aceTwo [i];	
				spriteBatch.Draw (playingCards, new Vector2 (300, 50), c.getSource (), Color.White);
			}
			for (int i = 0; i < aceThree.Count; i++) {
				cards c = (cards)aceThree [i];	
				spriteBatch.Draw (playingCards, new Vector2 (450, 50), c.getSource (), Color.White);
			}
			for (int i = 0; i < aceFour.Count; i++) {
				cards c = (cards)aceFour [i];	
				spriteBatch.Draw (playingCards, new Vector2 (600, 50), c.getSource (), Color.White);
			}

			turnOver ();
			moving ();
			movingMultipleCards();
			disCard ();
			putOnAce ();
			switchingMultipleCards ();
			switchCards ();
			king ();
		
			spriteBatch.End();


			//TODO: add your drawing code here


			base.Draw (gameTime);
		}

		/// <summary>
		/// So the following method was in the process of being finished prior to the final presentation
		/// and is therefore incomplete. Essentially, I was trying to write a method called king which says 
		/// that if a certain pile has no cards left in it, and another with a value of 13 (king) is placed 
		/// on that pile, then move the king and any cards under it into that pile. Because I decided to take 
		/// such an indirect root in coding this game, it is not water tight and this method is unfortunatly
		/// not finished.
		/// </summary>
		public void king(){

			if (stack.Count == 0 && one.Contains (new Point (current.X, current.Y))) {
				if (moving8 && pile [pile.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack.Add (pile [pile.Count - 1]);
						pile.RemoveAt (pile.Count - 1);
					}
				}
			}
			if (stack.Count == 0 && one.Contains (new Point (current.X, current.Y))) {
				if (moving7 && stack7 [stack7.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack.Add (stack7 [stack7.Count - 1]);
						stack7.RemoveAt (stack7.Count - 1);
					}
				}
			}
			if (stack.Count == 0 && one.Contains (new Point (current.X, current.Y))) {
				if (moving6 && stack6 [stack6.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack.Add (stack7 [stack6.Count - 1]);
						stack6.RemoveAt (stack6.Count - 1);
					}
				}
			}
			if (stack.Count == 0 && one.Contains (new Point (current.X, current.Y))) {
				if (moving5 && stack5 [stack5.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack.Add (stack5[stack5.Count - 1]);
						stack5.RemoveAt (stack5.Count - 1);
					}
				}
			}
			if (stack.Count == 0 && one.Contains (new Point (current.X, current.Y))) {
				if (moving4 && stack4 [stack4.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack.Add (stack4 [stack4.Count - 1]);
						stack4.RemoveAt (stack4.Count - 1);
					}
				}
			}if (stack.Count == 0 && one.Contains (new Point (current.X, current.Y))) {
				if (moving3 && stack3 [stack3.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack.Add (stack3 [stack3.Count - 1]);
						stack3.RemoveAt (stack3.Count - 1);
					}
				}
			}if (stack.Count == 0 && one.Contains (new Point (current.X, current.Y))) {
				if (moving2 && stack2 [stack2.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack.Add (stack2 [stack2.Count - 1]);
						stack2.RemoveAt (stack2.Count - 1);
					}
				}
			}
			if (stack2.Count == 0 && two.Contains (new Point (current.X, current.Y))) {
				if (moving8 && pile [pile.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack2.Add (pile [pile.Count - 1]);
						pile.RemoveAt (pile.Count - 1);
					}
				}
			}
			if (stack2.Count == 0 && two.Contains (new Point (current.X, current.Y))) {
				if (moving7 && stack7 [stack7.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack.Add (stack7 [stack7.Count - 1]);
						stack7.RemoveAt (stack7.Count - 1);
					}
				}
			}
			if (stack2.Count == 0 && two.Contains (new Point (current.X, current.Y))) {
				if (moving6 && stack6 [stack6.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack2.Add (stack7 [stack6.Count - 1]);
						stack6.RemoveAt (stack6.Count - 1);
					}
				}
			}
			if (stack2.Count == 0 && two.Contains (new Point (current.X, current.Y))) {
				if (moving5 && stack5 [stack5.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack2.Add (stack5[stack5.Count - 1]);
						stack5.RemoveAt (stack5.Count - 1);
					}
				}
			}
			if (stack2.Count == 0 && two.Contains (new Point (current.X, current.Y))) {
				if (moving4 && stack4 [stack4.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack2.Add (stack4 [stack4.Count - 1]);
						stack4.RemoveAt (stack4.Count - 1);
					}
				}
			}if (stack2.Count == 0 && two.Contains (new Point (current.X, current.Y))) {
				if (moving3 && stack3 [stack3.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack2.Add (stack3 [stack3.Count - 1]);
						stack3.RemoveAt (stack3.Count - 1);
					}
				}
			}if (stack2.Count == 0 && two.Contains (new Point (current.X, current.Y))) {
				if (moving1 && stack [stack.Count - 1].getValue () == 13) {
					if (current.LeftButton == ButtonState.Released) {
						stack2.Add (stack [stack.Count - 1]);
						stack.RemoveAt (stack.Count - 1);
					}
				}
			}


		}
		/// <summary>
		/// This method says that if the boolean for moving multiple cards is true for pile x and the value
		/// of the last card in pile y is one more and the color is different, take all the cards from pile x
		/// that are being moved and put them in pile y. Unfortunatly I wasn't able to come up with a way 
		/// to this in a neater and simpler way, so it is really really long, but its the same code just copied
		/// over and over to account for every possible situation that could arise.
		/// </summary>
		public void switchingMultipleCards(){

			if (one.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack [stack.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack [stack.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack.Add (movingCards [i]);
								stack2.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult2 = false;
						}
					}
				}
			}
			if (one.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack [stack.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack [stack.Count - 1].getValue ()) {
						movingCards.Clear ();
						movingMult2 = false;
					}
				}
			}

			if (three.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack3 [stack3.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack3 [stack3.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack3.Add (movingCards [i]);
								stack2.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult2 = false;
						}
					}
				}
			}
			if (three.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack3 [stack3.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack3 [stack3.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult2 = false;
					}
				}
			}
			if (four.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack4 [stack4.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack4 [stack4.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack4.Add (movingCards [i]);
								stack2.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult2 = false;
						}
					}
				}
			}
			if (four.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack4 [stack4.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack4 [stack4.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult2 = false;
					}
				}
			}
			if (five.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack5 [stack5.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack5 [stack5.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack5.Add (movingCards [i]);
								stack2.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult2 = false;
						}
					}
				}
			}
			if (five.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack5 [stack5.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack5 [stack5.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult2 = false;
					}
				}
			}	
			if (six.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack6 [stack6.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack6 [stack6.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack6.Add (movingCards [i]);
								stack2.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult2 = false;
						}
					}
				}
			}
			if (six.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack6 [stack6.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack6 [stack6.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult2 = false;
					}
				}
			}
			if (seven.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack7 [stack7.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack7 [stack7.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack7.Add (movingCards [i]);
								stack2.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult2 = false;
						}
					}
				}
			}
			if (seven.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack7 [stack7.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack7 [stack7.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult2 = false;
					}
				}
			}
			if (two.Contains (new Point (current.X, current.Y)) && movingMult1) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack2 [stack2.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack2 [stack2.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack2.Add (movingCards [i]);
								stack.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult1 = false;
						}
					}
				}
			}
			if (two.Contains (new Point (current.X, current.Y)) && movingMult1) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack2 [stack2.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack2[stack2.Count - 1].getValue ()) {
						movingCards.Clear ();
						movingMult1 = false;
					}
				}
			}

			if (three.Contains (new Point (current.X, current.Y)) && movingMult1) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack3 [stack3.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack3 [stack3.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack3.Add (movingCards [i]);
								stack.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult1 = false;
						}
					}
				}
			}
			if (three.Contains (new Point (current.X, current.Y)) && movingMult1) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack3 [stack3.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack3 [stack3.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult1 = false;
					}
				}
			}
			if (four.Contains (new Point (current.X, current.Y)) && movingMult1) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack4 [stack4.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack4 [stack4.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack4.Add (movingCards [i]);
								stack.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult1 = false;
						}
					}
				}
			}
			if (four.Contains (new Point (current.X, current.Y)) && movingMult1) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack4 [stack4.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack4 [stack4.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult1 = false;
					}
				}
			}
			if (five.Contains (new Point (current.X, current.Y)) && movingMult1) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack5 [stack5.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack5 [stack5.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack5.Add (movingCards [i]);
								stack.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult1 = false;
						}
					}
				}
			}
			if (five.Contains (new Point (current.X, current.Y)) && movingMult1) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack5 [stack5.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack5 [stack5.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult1 = false;
					}
				}
			}	
			if (six.Contains (new Point (current.X, current.Y)) && movingMult1) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack6 [stack6.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack6 [stack6.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack6.Add (movingCards [i]);
								stack.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult1 = false;
						}
					}
				}
			}
			if (six.Contains (new Point (current.X, current.Y)) && movingMult1) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack6 [stack6.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack6 [stack6.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult1 = false;
					}
				}
			}
			if (seven.Contains (new Point (current.X, current.Y)) && movingMult1) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack7 [stack7.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack7 [stack7.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack7.Add (movingCards [i]);
								stack.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult1 = false;
						}
					}
				}
			}
			if (seven.Contains (new Point (current.X, current.Y)) && movingMult1) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack7 [stack7.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack7 [stack7.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult1 = false;
					}
				}
			}if (one.Contains (new Point (current.X, current.Y)) && movingMult3) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack4 [stack.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack [stack.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack.Add (movingCards [i]);
								stack3.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult3 = false;
						}
					}
				}
			}
			if (one.Contains (new Point (current.X, current.Y)) && movingMult3) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack [stack.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack [stack.Count - 1].getValue ()) {
						movingCards.Clear ();
						movingMult3 = false;
					}
				}
			}

			if (two.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack2 [stack2.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack2 [stack2.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack2.Add (movingCards [i]);
								stack3.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult2 = false;
						}
					}
				}
			}
			if (two.Contains (new Point (current.X, current.Y)) && movingMult3) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack2 [stack2.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack2 [stack2.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult3 = false;
					}
				}
			}
			if (four.Contains (new Point (current.X, current.Y)) && movingMult3) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack4 [stack4.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack4 [stack4.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack4.Add (movingCards [i]);
								stack3.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult3 = false;
						}
					}
				}
			}
			if (four.Contains (new Point (current.X, current.Y)) && movingMult3) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack4 [stack4.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack4 [stack4.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult3 = false;
					}
				}
			}
			if (five.Contains (new Point (current.X, current.Y)) && movingMult3) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack5 [stack5.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack5 [stack5.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack5.Add (movingCards [i]);
								stack3.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult3 = false;
						}
					}
				}
			}
			if (five.Contains (new Point (current.X, current.Y)) && movingMult3) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack5 [stack5.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack5 [stack5.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult3 = false;
					}
				}
			}	
			if (six.Contains (new Point (current.X, current.Y)) && movingMult3) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack6 [stack6.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack6 [stack6.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack6.Add (movingCards [i]);
								stack3.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult3 = false;
						}
					}
				}
			}
			if (six.Contains (new Point (current.X, current.Y)) && movingMult3) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack6 [stack6.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack6 [stack6.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult3 = false;
					}
				}
			}
			if (seven.Contains (new Point (current.X, current.Y)) && movingMult3) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack7 [stack7.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack7 [stack7.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack7.Add (movingCards [i]);
								stack3.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult3 = false;
						}
					}
				}
			}
			if (seven.Contains (new Point (current.X, current.Y)) && movingMult3) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack7 [stack7.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack7 [stack7.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult3 = false;
					}
				}
			}if (one.Contains (new Point (current.X, current.Y)) && movingMult4) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack4 [stack.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack [stack.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack.Add (movingCards [i]);
								stack4.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult4 = false;
						}
					}
				}
			}
			if (one.Contains (new Point (current.X, current.Y)) && movingMult4) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack [stack.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack [stack.Count - 1].getValue ()) {
						movingCards.Clear ();
						movingMult4 = false;
					}
				}
			}

			if (three.Contains (new Point (current.X, current.Y)) && movingMult4) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack3 [stack3.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack3 [stack3.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack3.Add (movingCards [i]);
								stack4.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult4 = false;
						}
					}
				}
			}
			if (three.Contains (new Point (current.X, current.Y)) && movingMult4) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack3 [stack3.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack3 [stack3.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult4 = false;
					}
				}
			}
			if (two.Contains (new Point (current.X, current.Y)) && movingMult4) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack2[stack2.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack2 [stack2.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack2.Add (movingCards [i]);
								stack4.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult4 = false;
						}
					}
				}
			}
			if (two.Contains (new Point (current.X, current.Y)) && movingMult4) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack2 [stack2.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack2 [stack2.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult4 = false;
					}
				}
			}
			if (five.Contains (new Point (current.X, current.Y)) && movingMult4) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack5 [stack5.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack5 [stack5.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack5.Add (movingCards [i]);
								stack4.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult4 = false;
						}
					}
				}
			}
			if (five.Contains (new Point (current.X, current.Y)) && movingMult4) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack5 [stack5.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack5 [stack5.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult4 = false;
					}
				}
			}	
			if (six.Contains (new Point (current.X, current.Y)) && movingMult4) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack6 [stack6.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack6 [stack6.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack6.Add (movingCards [i]);
								stack4.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult4 = false;
						}
					}
				}
			}
			if (six.Contains (new Point (current.X, current.Y)) && movingMult4) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack6 [stack6.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack6 [stack6.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult4 = false;
					}
				}
			}
			if (seven.Contains (new Point (current.X, current.Y)) && movingMult4) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack7 [stack7.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack7 [stack7.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack7.Add (movingCards [i]);
								stack4.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult4 = false;
						}
					}
				}
			}
			if (seven.Contains (new Point (current.X, current.Y)) && movingMult4) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack7 [stack7.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack7 [stack7.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult4 = false;
					}
				}
			}if (one.Contains (new Point (current.X, current.Y)) && movingMult5) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack4 [stack.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack [stack.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack.Add (movingCards [i]);
								stack5.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult5 = false;
						}
					}
				}
			}
			if (one.Contains (new Point (current.X, current.Y)) && movingMult5) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack [stack.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack [stack.Count - 1].getValue ()) {
						movingCards.Clear ();
						movingMult5 = false;
					}
				}
			}

			if (three.Contains (new Point (current.X, current.Y)) && movingMult5) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack3 [stack3.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack3 [stack3.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack3.Add (movingCards [i]);
								stack5.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult5 = false;
						}
					}
				}
			}
			if (three.Contains (new Point (current.X, current.Y)) && movingMult5) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack3 [stack3.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack3 [stack3.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult5 = false;
					}
				}
			}
			if (four.Contains (new Point (current.X, current.Y)) && movingMult5) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack4 [stack4.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack4 [stack4.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack4.Add (movingCards [i]);
								stack5.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult5 = false;
						}
					}
				}
			}
			if (four.Contains (new Point (current.X, current.Y)) && movingMult5) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack4 [stack4.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack4 [stack4.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult5 = false;
					}
				}
			}
			if (two.Contains (new Point (current.X, current.Y)) && movingMult5) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack2 [stack2.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack2 [stack2.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack2.Add (movingCards [i]);
								stack5.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult5 = false;
						}
					}
				}
			}
			if (two.Contains (new Point (current.X, current.Y)) && movingMult2) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack2 [stack2.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack2 [stack2.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult5 = false;
					}
				}
			}	
			if (six.Contains (new Point (current.X, current.Y)) && movingMult5) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack6 [stack6.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack6 [stack6.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack6.Add (movingCards [i]);
								stack5.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult5 = false;
						}
					}
				}
			}
			if (six.Contains (new Point (current.X, current.Y)) && movingMult5) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack6 [stack6.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack6 [stack6.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult5 = false;
					}
				}
			}
			if (seven.Contains (new Point (current.X, current.Y)) && movingMult5) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack7 [stack7.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack7 [stack7.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack7.Add (movingCards [i]);
								stack5.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult5 = false;
						}
					}
				}
			}
			if (seven.Contains (new Point (current.X, current.Y)) && movingMult5) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack7 [stack7.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack7 [stack7.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult5 = false;
					}
				}
			}if (one.Contains (new Point (current.X, current.Y)) && movingMult6) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack4 [stack.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack [stack.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack.Add (movingCards [i]);
								stack6.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult6 = false;
						}
					}
				}
			}
			if (one.Contains (new Point (current.X, current.Y)) && movingMult6) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack [stack.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack [stack.Count - 1].getValue ()) {
						movingCards.Clear ();
						movingMult6 = false;
					}
				}
			}

			if (three.Contains (new Point (current.X, current.Y)) && movingMult6) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack3 [stack3.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack3 [stack3.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack3.Add (movingCards [i]);
								stack2.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult6 = false;
						}
					}
				}
			}
			if (three.Contains (new Point (current.X, current.Y)) && movingMult6) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack3 [stack3.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack3 [stack3.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult6 = false;
					}
				}
			}
			if (four.Contains (new Point (current.X, current.Y)) && movingMult6) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack4 [stack4.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack4 [stack4.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack4.Add (movingCards [i]);
								stack6.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult6 = false;
						}
					}
				}
			}
			if (four.Contains (new Point (current.X, current.Y)) && movingMult6) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack4 [stack4.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack4 [stack4.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult6 = false;
					}
				}
			}
			if (five.Contains (new Point (current.X, current.Y)) && movingMult6) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack5 [stack5.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack5 [stack5.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack5.Add (movingCards [i]);
								stack6.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult6 = false;
						}
					}
				}
			}
			if (five.Contains (new Point (current.X, current.Y)) && movingMult6) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack5 [stack5.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack5 [stack5.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult6 = false;
					}
				}
			}	
			if (two.Contains (new Point (current.X, current.Y)) && movingMult6) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack2 [stack2.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack2 [stack2.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack2.Add (movingCards [i]);
								stack6.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult6 = false;
						}
					}
				}
			}
			if (two.Contains (new Point (current.X, current.Y)) && movingMult6) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack2 [stack2.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack2 [stack2.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult6 = false;
					}
				}
			}
			if (seven.Contains (new Point (current.X, current.Y)) && movingMult6) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack7 [stack7.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack7 [stack7.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack7.Add (movingCards [i]);
								stack6.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult6 = false;
						}
					}
				}
			}
			if (seven.Contains (new Point (current.X, current.Y)) && movingMult6) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack7 [stack7.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack7 [stack7.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult6 = false;
					}
				}
			}if (one.Contains (new Point (current.X, current.Y)) && movingMult7) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack4 [stack.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack [stack.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack.Add (movingCards [i]);
								stack7.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult7 = false;
						}
					}
				}
			}
			if (one.Contains (new Point (current.X, current.Y)) && movingMult7) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack [stack.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack [stack.Count - 1].getValue ()) {
						movingCards.Clear ();
						movingMult7 = false;
					}
				}
			}

			if (three.Contains (new Point (current.X, current.Y)) && movingMult7) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack3 [stack3.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack3 [stack3.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack3.Add (movingCards [i]);
								stack7.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult7 = false;
						}
					}
				}
			}
			if (three.Contains (new Point (current.X, current.Y)) && movingMult7) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack3 [stack3.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack3 [stack3.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult7 = false;
					}
				}
			}
			if (four.Contains (new Point (current.X, current.Y)) && movingMult7) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack4 [stack4.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack4 [stack4.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack4.Add (movingCards [i]);
								stack7.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult7 = false;
						}
					}
				}
			}
			if (four.Contains (new Point (current.X, current.Y)) && movingMult7) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack4 [stack4.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack4 [stack4.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult7 = false;
					}
				}
			}
			if (five.Contains (new Point (current.X, current.Y)) && movingMult7) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack5 [stack5.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack5 [stack5.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack5.Add (movingCards [i]);
								stack2.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult7 = false;
						}
					}
				}
			}
			if (five.Contains (new Point (current.X, current.Y)) && movingMult7) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack5 [stack5.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack5 [stack5.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult7 = false;
					}
				}
			}	
			if (six.Contains (new Point (current.X, current.Y)) && movingMult7) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack6 [stack6.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack6 [stack6.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack6.Add (movingCards [i]);
								stack7.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult7 = false;
						}
					}
				}
			}
			if (six.Contains (new Point (current.X, current.Y)) && movingMult7) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack6 [stack6.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack6 [stack6.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult7 = false;
					}
				}
			}
			if (two.Contains (new Point (current.X, current.Y)) && movingMult7) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () != stack2 [stack2.Count - 1].getColor ()) {
						if (movingCards [0].getValue () + 1 == stack2 [stack2.Count - 1].getValue ()) {
							for (int i = 0; i < movingCards.Count; i++) {
								stack2.Add (movingCards [i]);
								stack7.Remove (movingCards[i]);
							}
							movingCards.Clear ();
							movingMult7 = false;
						}
					}
				}
			}
			if (two.Contains (new Point (current.X, current.Y)) && movingMult7) {
				if (current.LeftButton == ButtonState.Released) {
					if (movingCards [0].getColor () == stack2 [stack2.Count - 1].getColor () || movingCards [0].getValue () + 1 != stack2 [stack2.Count - 1].getValue ()) {


						movingCards.Clear ();
						movingMult7 = false;
					}
				}
			}


		
		
		}
		

	/// <summary>
	/// This method was simple, it basically is saying that if the value of the card being
	/// being placed on top of one of the final piles is equal to the value of the integer called ace slot
	/// add it to the ace slot list, remove it from whatever list it came from and add one to the ace slot integer.
	/// </summary>
		public void putOnAce (){

			if (aceSlot1.Contains (new Point (current.X, current.Y)) && moving1) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack [stack.Count - 1].getSuit () == 1) {
						if (stack [stack.Count - 1].getValue () == aceSlotOne) {
							aceOne.Add (stack [stack.Count - 1]);
							stack.RemoveAt (stack.Count - 1);
							aceSlotOne++;
							moving1 = false;

						}
					
					}
				}
			}

			if (aceSlot1.Contains (new Point (current.X, current.Y)) && moving2) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack2 [stack2.Count - 1].getSuit () == 1) {
						if (stack2 [stack2.Count - 1].getValue () == aceSlotOne) {
							aceOne.Add (stack2 [stack2.Count - 1]);
							stack2.RemoveAt (stack2.Count - 1);
							aceSlotOne++;
							moving2 = false;

						}
					}
				}
			}

			if (aceSlot1.Contains (new Point (current.X, current.Y)) && moving3) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack3 [stack3.Count - 1].getSuit () == 1) {
						if (stack3 [stack3.Count - 1].getValue () == aceSlotOne) {
							aceOne.Add (stack3 [stack3.Count - 1]);
							stack3.RemoveAt (stack3.Count - 1);
							aceSlotOne++;
							moving3 = false;

						}
					}
				}
			}
			if (aceSlot1.Contains (new Point (current.X, current.Y)) && moving4) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack4 [stack4.Count - 1].getSuit () == 1) {
						if (stack4 [stack4.Count - 1].getValue () == aceSlotOne) {
							aceOne.Add (stack4 [stack4.Count - 1]);
							stack4.RemoveAt (stack4.Count - 1);
							aceSlotOne++;
							moving4 = false;

						}
					}
				}
			}
			if (aceSlot1.Contains (new Point (current.X, current.Y)) && moving5) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack5 [stack5.Count - 1].getSuit () == 1) {
						if (stack5 [stack5.Count - 1].getValue () == aceSlotOne) {
							aceOne.Add (stack5 [stack5.Count - 1]);
							stack5.RemoveAt (stack5.Count - 1);
							aceSlotOne++;
							moving5 = false;

						}
					}
				}
			}
			if (aceSlot1.Contains (new Point (current.X, current.Y)) && moving6) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack6 [stack6.Count - 1].getSuit () == 1) {
						if (stack6 [stack6.Count - 1].getValue () == aceSlotOne) {
							aceOne.Add (stack6 [stack6.Count - 1]);
							stack6.RemoveAt (stack6.Count - 1);
							aceSlotOne++;
							moving6 = false;

						}
					}
				}
			}
			if (aceSlot1.Contains (new Point (current.X, current.Y)) && moving7) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack7 [stack7.Count - 1].getSuit () == 1) {
						if (stack7 [stack7.Count - 1].getValue () == aceSlotOne) {
							aceOne.Add (stack7 [stack7.Count - 1]);
							stack7.RemoveAt (stack7.Count - 1);
							aceSlotOne++;
							moving7 = false;

						}
					}
				}
			}
		
		
			if (aceSlot1.Contains (new Point (current.X, current.Y)) && moving8) {
				if (current.LeftButton == ButtonState.Released) {
					if (pile[pile.Count - 1].getSuit () == 1) {
						if (pile[pile.Count - 1].getValue () == aceSlotOne) {
							aceOne.Add (pile [pile.Count - 1]);
							pile.RemoveAt (pile.Count - 1);
							aceSlotOne++;
							moving8 = false;

						}
					}
				}
			}
			if (aceSlot2.Contains (new Point (current.X, current.Y)) && moving1) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack [stack.Count - 1].getSuit () == 2) {
						if (stack [stack.Count - 1].getValue () == aceSlotTwo) {
							aceTwo.Add (stack [stack.Count - 1]);
							stack.RemoveAt (stack.Count - 1);
							aceSlotTwo++;
							moving1 = false;

						}
					}
				}
			}

			if (aceSlot2.Contains (new Point (current.X, current.Y)) && moving2) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack2 [stack2.Count - 1].getSuit () == 2) {
						if (stack2 [stack2.Count - 1].getValue () == aceSlotTwo) {
							aceTwo.Add (stack2 [stack2.Count - 1]);
							stack2.RemoveAt (stack2.Count - 1);
							aceSlotTwo++;
							moving2 = false;

						}
					}
				}
			}

			if (aceSlot2.Contains (new Point (current.X, current.Y)) && moving3) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack3 [stack3.Count - 1].getSuit () == 2) {
						if (stack3 [stack3.Count - 1].getValue () == aceSlotTwo) {
							aceTwo.Add (stack3 [stack3.Count - 1]);
							stack3.RemoveAt (stack3.Count - 1);
							aceSlotTwo++;
							moving3 = false;

						}
					}
				}
			}
			if (aceSlot2.Contains (new Point (current.X, current.Y)) && moving4) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack4 [stack4.Count - 1].getSuit () == 2) {
						if (stack4 [stack4.Count - 1].getValue () == aceSlotTwo) {
							aceTwo.Add (stack4 [stack4.Count - 1]);
							stack4.RemoveAt (stack4.Count - 1);
							aceSlotTwo++;
							moving4 = false;

						}
					}
				}
			}
			if (aceSlot2.Contains (new Point (current.X, current.Y)) && moving5) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack5 [stack5.Count - 1].getSuit () == 2) {
						if (stack5 [stack5.Count - 1].getValue () == aceSlotTwo) {
							aceTwo.Add (stack5 [stack5.Count - 1]);
							stack5.RemoveAt (stack5.Count - 1);
							aceSlotTwo++;
							moving5 = false;

						}
					}
				}
			}
			if (aceSlot2.Contains (new Point (current.X, current.Y)) && moving6) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack6 [stack6.Count - 1].getSuit () == 2) {
						if (stack6 [stack6.Count - 1].getValue () == aceSlotTwo) {
							aceTwo.Add (stack6 [stack6.Count - 1]);
							stack6.RemoveAt (stack6.Count - 1);
							aceSlotTwo++;
							moving6 = false;

						}
					}
				}
			}
			if (aceSlot2.Contains (new Point (current.X, current.Y)) && moving7) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack7 [stack7.Count - 1].getSuit () == 2) {
						if (stack7 [stack7.Count - 1].getValue () == aceSlotTwo) {
							aceTwo.Add (stack7 [stack7.Count - 1]);
							stack7.RemoveAt (stack7.Count - 1);
							aceSlotTwo++;
							moving7 = false;

						}
					}
				}
			}


			if (aceSlot2.Contains (new Point (current.X, current.Y)) && moving8) {
				if (current.LeftButton == ButtonState.Released) {
					if (pile[pile.Count - 1].getSuit () == 2) {
						if (pile[pile.Count - 1].getValue () == aceSlotTwo) {
							aceTwo.Add (pile [pile.Count - 1]);
							pile.RemoveAt (pile.Count - 1);
							aceSlotTwo++;
							moving8 = false;

						}
					}
				}
			}
			if (aceSlot3.Contains (new Point (current.X, current.Y)) && moving1) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack [stack.Count - 1].getSuit () == 3) {
						if (stack [stack.Count - 1].getValue () == aceSlotThree) {
							aceThree.Add (stack [stack.Count - 1]);
							stack.RemoveAt (stack.Count - 1);
							aceSlotThree++;
							moving1 = false;

						}
					}
				}
			}

			if (aceSlot3.Contains (new Point (current.X, current.Y)) && moving2) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack2 [stack2.Count - 1].getSuit () == 3) {
						if (stack2 [stack2.Count - 1].getValue () == aceSlotThree) {
							aceThree.Add (stack2 [stack2.Count - 1]);
							stack2.RemoveAt (stack2.Count - 1);
							aceSlotThree++;
							moving2 = false;

						}
					}
				}
			}

			if (aceSlot3.Contains (new Point (current.X, current.Y)) && moving3) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack3 [stack3.Count - 1].getSuit () == 3) {
						if (stack3 [stack3.Count - 1].getValue () == aceSlotThree) {
							aceThree.Add (stack3 [stack3.Count - 1]);
							stack3.RemoveAt (stack3.Count - 1);
							aceSlotThree++;
							moving3 = false;

						}
					}
				}
			}
			if (aceSlot3.Contains (new Point (current.X, current.Y)) && moving4) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack4 [stack4.Count - 1].getSuit () == 3) {
						if (stack4 [stack4.Count - 1].getValue () == aceSlotThree) {
							aceThree.Add (stack4 [stack4.Count - 1]);
							stack4.RemoveAt (stack4.Count - 1);
							aceSlotThree++;
							moving4 = false;

						}
					}
				}
			}
			if (aceSlot3.Contains (new Point (current.X, current.Y)) && moving5) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack5 [stack5.Count - 1].getSuit () == 3) {
						if (stack5 [stack5.Count - 1].getValue () == aceSlotThree) {
							aceThree.Add (stack5 [stack5.Count - 1]);
							stack5.RemoveAt (stack5.Count - 1);
							aceSlotThree++;
							moving5 = false;

						}
					}
				}
			}
			if (aceSlot3.Contains (new Point (current.X, current.Y)) && moving6) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack6 [stack6.Count - 1].getSuit () == 3) {
						if (stack6 [stack6.Count - 1].getValue () == aceSlotThree) {
							aceThree.Add (stack6 [stack6.Count - 1]);
							stack6.RemoveAt (stack6.Count - 1);
							aceSlotThree++;
							moving6 = false;

						}
					}
				}
			}
			if (aceSlot3.Contains (new Point (current.X, current.Y)) && moving7) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack7 [stack7.Count - 1].getSuit () == 3) {
						if (stack7 [stack7.Count - 1].getValue () == aceSlotThree) {
							aceThree.Add (stack7 [stack7.Count - 1]);
							stack7.RemoveAt (stack7.Count - 1);
							aceSlotThree++;
							moving7 = false;

						}
					}
				}
			}


			if (aceSlot3.Contains (new Point (current.X, current.Y)) && moving8) {
				if (current.LeftButton == ButtonState.Released) {
					if (pile[pile.Count - 1].getSuit () == 3) {
						if (pile[pile.Count - 1].getValue () == aceSlotThree) {
							aceThree.Add (pile [pile.Count - 1]);
							pile.RemoveAt (pile.Count - 1);
							aceSlotThree++;
							moving8 = false;

						}
					}
				}
			}
			if (aceSlot4.Contains (new Point (current.X, current.Y)) && moving1) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack [stack.Count - 1].getSuit () == 4) {
						if (stack [stack.Count - 1].getValue () == aceSlotFour) {
							aceFour.Add (stack [stack.Count - 1]);
							stack.RemoveAt (stack.Count - 1);
							aceSlotFour++;
							moving1 = false;

						}
					}
				}
			}

			if (aceSlot4.Contains (new Point (current.X, current.Y)) && moving2) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack2 [stack2.Count - 1].getSuit () == 4) {
						if (stack2 [stack2.Count - 1].getValue () == aceSlotFour) {
							aceFour.Add (stack2 [stack2.Count - 1]);
							stack2.RemoveAt (stack2.Count - 1);
							aceSlotFour++;
							moving2 = false;

						}
					}
				}
			}

			if (aceSlot4.Contains (new Point (current.X, current.Y)) && moving3) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack3 [stack3.Count - 1].getSuit () == 4) {
						if (stack3 [stack3.Count - 1].getValue () == aceSlotFour) {
							aceFour.Add (stack3 [stack3.Count - 1]);
							stack3.RemoveAt (stack3.Count - 1);
							aceSlotFour++;
							moving3 = false;

						}
					}
				}
			}
			if (aceSlot4.Contains (new Point (current.X, current.Y)) && moving4) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack4 [stack4.Count - 1].getSuit () == 4) {
						if (stack4 [stack4.Count - 1].getValue () == aceSlotFour) {
							aceFour.Add (stack4 [stack4.Count - 1]);
							stack4.RemoveAt (stack4.Count - 1);
							aceSlotFour++;
							moving4 = false;

						}
					}
				}
			}
			if (aceSlot4.Contains (new Point (current.X, current.Y)) && moving5) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack5 [stack5.Count - 1].getSuit () == 4) {
						if (stack5 [stack5.Count - 1].getValue () == aceSlotFour) {
							aceFour.Add (stack5 [stack5.Count - 1]);
							stack5.RemoveAt (stack5.Count - 1);
							aceSlotFour++;
							moving5 = false;

						}
					}
				}
			}
			if (aceSlot4.Contains (new Point (current.X, current.Y)) && moving6) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack6 [stack6.Count - 1].getSuit () == 4) {
						if (stack6 [stack6.Count - 1].getValue () == aceSlotFour) {
							aceFour.Add (stack6 [stack6.Count - 1]);
							stack6.RemoveAt (stack6.Count - 1);
							aceSlotFour++;
							moving6 = false;

						}
					}
				}
			}
			if (aceSlot4.Contains (new Point (current.X, current.Y)) && moving7) {
				if (current.LeftButton == ButtonState.Released) {
					if (stack7 [stack7.Count - 1].getSuit () == 4) {
						if (stack7 [stack7.Count - 1].getValue () == aceSlotFour) {
							aceFour.Add (stack7 [stack7.Count - 1]);
							stack7.RemoveAt (stack7.Count - 1);
							aceSlotFour++;
							moving7 = false;

						}
					}
				}
			}


			if (aceSlot4.Contains (new Point (current.X, current.Y)) && moving8) {
				if (current.LeftButton == ButtonState.Released) {
					if (pile[pile.Count - 1].getSuit () == 4) {
						if (pile[pile.Count - 1].getValue () == aceSlotFour) {
							aceFour.Add (pile [pile.Count - 1]);
							pile.RemoveAt (pile.Count - 1);
							aceSlotFour++;
							moving8 = false;

						}
					}
				}
			}
		
		
		
		}
			
		/// <summary>
		/// This method does two things, it gets rid of cards from the dealt pile if the card
		/// is not needed by the user. It also has the logic embbedded in it which allows cards
		/// to be taken from the draw pile and added to any of the piles in the game if the color 
		/// is the opposite and the value is one less.
		/// </summary>
		public void disCard (){
			if (discard.Contains (new Point (current.X, current.Y)) && moving8) {
				if (current.LeftButton == ButtonState.Released) {
					dealt.Add (pile [pile.Count - 1]);
					pile.RemoveAt (pile.Count - 1);
					moving8 = false;
				}
			}



			if (stack.Count > 0) {
				if (one.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () != pile [pile.Count - 1].getColor ()) {
							if (stack [stack.Count - 1].getValue () == pile [pile.Count - 1].getValue () + 1) {
								stack.Add (pile [pile.Count - 1]);
								pile.RemoveAt (pile.Count - 1);
								moving8 = false;
							}
						}
					}
				}
				if (one.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () == pile [pile.Count - 1].getColor () || (stack [stack.Count - 1].getValue () != pile [pile.Count - 1].getValue () + 1)) {
							moving8 = false;
						}
					}
				}
			}
			if (stack2.Count > 0) {
				if (two.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () != pile [pile.Count - 1].getColor ()) {
							if (stack2 [stack2.Count - 1].getValue () == pile [pile.Count - 1].getValue () + 1) {
								stack2.Add (pile [pile.Count - 1]);
								pile.RemoveAt (pile.Count - 1);
								moving8 = false;
							}
						}
					}
				}
				if (two.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () == pile [pile.Count - 1].getColor () || (stack2 [stack2.Count - 1].getValue () != pile [pile.Count - 1].getValue () + 1)) {
							moving8 = false;
						}
					}
				}
			}
			if (stack3.Count > 0) {
				if (three.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () != pile [pile.Count - 1].getColor ()) {
							if (stack3 [stack3.Count - 1].getValue () == pile [pile.Count - 1].getValue () + 1) {
								stack3.Add (pile [pile.Count - 1]);
								pile.RemoveAt (pile.Count - 1);
								moving8 = false;
							}
						}
					}
				}
				if (three.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () == pile [pile.Count - 1].getColor () || (stack3 [stack3.Count - 1].getValue () != pile [pile.Count - 1].getValue () + 1)) {
							moving8 = false;
						}
					}
				}
			}
			if (stack4.Count > 0) {
				if (four.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () != pile [pile.Count - 1].getColor ()) {
							if (stack4 [stack4.Count - 1].getValue () == pile [pile.Count - 1].getValue () + 1) {
								stack4.Add (pile [pile.Count - 1]);
								pile.RemoveAt (pile.Count - 1);
								moving8 = false;
							}
						}
					}
				}
				if (four.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () == pile [pile.Count - 1].getColor () || (stack4 [stack4.Count - 1].getValue () != pile [pile.Count - 1].getValue () + 1)) {
							moving8 = false;
						}
					}
				}
			}
			if (stack5.Count > 0) {
				if (five.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () != pile [pile.Count - 1].getColor ()) {
							if (stack5 [stack5.Count - 1].getValue () == pile [pile.Count - 1].getValue () + 1) {
								stack5.Add (pile [pile.Count - 1]);
								pile.RemoveAt (pile.Count - 1);
								moving8 = false;
							}
						}
					}
				}
				if (five.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () == pile [pile.Count - 1].getColor () || (stack5 [stack5.Count - 1].getValue () != pile [pile.Count - 1].getValue () + 1)) {
							moving8 = false;
						}
					}
				}
			}
			if (six.Contains (new Point (current.X, current.Y)) && moving8) { 
				if (current.LeftButton == ButtonState.Released) {
					if (stack6 [stack6.Count - 1].getColor () != pile [pile.Count - 1].getColor ()) {
						if (stack6 [stack6.Count - 1].getValue () == pile [pile.Count - 1].getValue () + 1) {
							stack6.Add (pile [pile.Count - 1]);
							pile.RemoveAt (pile.Count - 1);
							moving8 = false;
						}
					}
				}
			}
			if (stack6.Count > 0) {
				if (six.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () == pile [pile.Count - 1].getColor () || (stack6 [stack6.Count - 1].getValue () != pile [pile.Count - 1].getValue () + 1)) {
							moving8 = false;
						}
					}
				}
				if (seven.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () != pile [pile.Count - 1].getColor ()) {
							if (stack7 [stack7.Count - 1].getValue () == pile [pile.Count - 1].getValue () + 1) {
								stack7.Add (pile [pile.Count - 1]);
								pile.RemoveAt (pile.Count - 1);
								moving8 = false;

							}
						}
					}
				}
			
				if (seven.Contains (new Point (current.X, current.Y)) && moving8) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () == pile [pile.Count - 1].getColor () || (stack7 [stack7.Count - 1].getValue () != pile [pile.Count - 1].getValue () + 1)) {
							moving8 = false;
						}
					}
				}
			}
		}

		/// <summary>
		/// This method goes through each stack and using a self made method 
		/// from my cards class called isShowing which returns a boolean to check
		/// if the card is showing, if not and the mouse is on it and the left 
		/// click is pressed, then flip the card around to display the value.
		/// </summary>
		public void turnOver (){ 

			if (stack2.Count > 0) {
				if (!stack2 [stack2.Count - 1].isShowing ()) {
					if (two.Contains (new Point (current.X, current.Y))) {
						if (current.LeftButton == ButtonState.Pressed) {
							stack2 [stack2.Count - 1].flip ();	
						}
					}
				}
			}
			if (stack3.Count > 0) {
				if (!stack3 [stack3.Count - 1].isShowing ()) {
					if (three.Contains (new Point (current.X, current.Y))) {
						if (current.LeftButton == ButtonState.Pressed) {
							stack3 [stack3.Count - 1].flip ();	
						}
					}
				}
			}
			if (stack4.Count > 0) {
				if (!stack4 [stack4.Count - 1].isShowing ()) {
					if (four.Contains (new Point (current.X, current.Y))) {
						if (current.LeftButton == ButtonState.Pressed) {
							stack4 [stack4.Count - 1].flip ();	
						}
					}
				}
			}

			if (stack5.Count > 0) {
				if (!stack5 [stack5.Count - 1].isShowing ()) {
					if (five.Contains (new Point (current.X, current.Y))) {
						if (current.LeftButton == ButtonState.Pressed) {
							stack5 [stack5.Count - 1].flip ();	
						}
					}
				}
			}

			if (stack6.Count > 0) {
				if (!stack6 [stack6.Count - 1].isShowing ()) {
					if (six.Contains (new Point (current.X, current.Y))) {
						if (current.LeftButton == ButtonState.Pressed) {
							stack6 [stack6.Count - 1].flip ();	
						}
					}
				}
			}
			if (stack7.Count > 0) {
				if (!stack7 [stack7.Count - 1].isShowing ()) {
					if (seven.Contains (new Point (current.X, current.Y))) {
						if (current.LeftButton == ButtonState.Pressed) {
							stack7 [stack7.Count - 1].flip ();	
						}
					}
				}
			}
		
			if (pile.Count > 0) {
				if (!pile [pile.Count - 1].isShowing ()) {
					if (eight.Contains (new Point (current.X, current.Y))) {
						if (current.LeftButton == ButtonState.Pressed) {
							pile [pile.Count - 1].flip ();	
						}
					}
				}
			}

		
		}

		/// <summary>
		/// This method is essentially the same logic as the moving multiple cards method. However,
		/// instead of having a stack of cards moving we are just concerned with the last card in the stack
		/// it is being taken from which is equal to index [stackX.Count-1].
		/// </summary>
		public void switchCards (){

			if (stack2.Count > 0) {
				if (two.Contains (new Point (current.X, current.Y)) && moving1) {
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () != stack [stack.Count - 1].getColor ()) {
							if (stack2 [stack2.Count - 1].getValue () == stack [stack.Count - 1].getValue () + 1) {
								stack2.Add (stack [stack.Count - 1]);
								stack.RemoveAt (stack.Count - 1);
								moving1 = false;
							}
						}
					}
				}
				if (two.Contains (new Point (current.X, current.Y)) && moving1) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () == stack [stack.Count - 1].getColor () || (stack2 [stack2.Count - 1].getValue () != stack [stack.Count - 1].getValue () + 1)) {
							moving1 = false;
						}
					}
				}
			}
			if (stack3.Count > 0) {
				if (three.Contains (new Point (current.X, current.Y)) && moving1) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () != stack [stack.Count - 1].getColor ()) {
							if (stack3 [stack3.Count - 1].getValue () == stack [stack.Count - 1].getValue () + 1) {
								stack3.Add (stack [stack.Count - 1]);
								stack.RemoveAt (stack.Count - 1);
								moving1 = false;
							}
						}
					}
				}
				if (three.Contains (new Point (current.X, current.Y)) && moving1) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () == stack [stack.Count - 1].getColor () || (stack3 [stack3.Count - 1].getValue () != stack [stack.Count - 1].getValue () + 1)) {
							moving1 = false;
						}
					}
				}
			}
			if (stack4.Count > 0) {
				if (four.Contains (new Point (current.X, current.Y)) && moving1) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () != stack [stack.Count - 1].getColor ()) {
							if (stack4 [stack4.Count - 1].getValue () == stack [stack.Count - 1].getValue () + 1) {
								stack4.Add (stack [stack.Count - 1]);
								stack.RemoveAt (stack.Count - 1);
								moving1 = false;
							}
						}
					}
				}
				if (four.Contains (new Point (current.X, current.Y)) && moving1) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () == stack [stack.Count - 1].getColor () || (stack4 [stack4.Count - 1].getValue () != stack [stack.Count - 1].getValue () + 1)) {
							moving1 = false;
						}
					}
				}
			}
			if (stack5.Count > 0) {
				if (five.Contains (new Point (current.X, current.Y)) && moving1) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () != stack [stack.Count - 1].getColor ()) {
							if (stack5 [stack5.Count - 1].getValue () == stack [stack.Count - 1].getValue () + 1) {
								stack5.Add (stack5 [stack.Count - 1]);
								stack.RemoveAt (stack.Count - 1);
								moving1 = false;
							}
						}
					}
				}
				if (five.Contains (new Point (current.X, current.Y)) && moving1) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () == stack [stack.Count - 1].getColor () || (stack5 [stack5.Count - 1].getValue () != stack [stack.Count - 1].getValue () + 1)) {
							moving1 = false;
						}
					}
				}
			}
			if (stack6.Count > 0) {
				if (six.Contains (new Point (current.X, current.Y)) && moving1) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () != stack [stack.Count - 1].getColor ()) {
							if (stack6 [stack6.Count - 1].getValue () == stack [stack.Count - 1].getValue () + 1) {
								stack6.Add (stack [stack.Count - 1]);
								stack.RemoveAt (stack.Count - 1);
								moving1 = false;
							}
						}
					}
				}
				if (six.Contains (new Point (current.X, current.Y)) && moving1) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () == stack [stack.Count - 1].getColor () || (stack6 [stack6.Count - 1].getValue () != stack [stack.Count - 1].getValue () + 1)) {
							moving1 = false;
						}
					}
				}
			}
			if (stack7.Count > 0) {
				if (seven.Contains (new Point (current.X, current.Y)) && moving1) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () != stack [stack.Count - 1].getColor ()) {
							if (stack7 [stack7.Count - 1].getValue () == stack [stack.Count - 1].getValue () + 1) {
								stack7.Add (stack [stack.Count - 1]);
								stack.RemoveAt (stack.Count - 1);
								moving1 = false;
							}
						}
					}
				}
				if (seven.Contains (new Point (current.X, current.Y)) && moving1) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () == stack [stack.Count - 1].getColor () || (stack7 [stack7.Count - 1].getValue () != stack [stack.Count - 1].getValue () + 1)) {
							moving1 = false;
						}
					}
				}
			}
			if (stack.Count > 0) {
				if (one.Contains (new Point (current.X, current.Y)) && moving2) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () != stack2 [stack2.Count - 1].getColor ()) {
							if (stack [stack.Count - 1].getValue () == stack2 [stack2.Count - 1].getValue () + 1) {
								stack.Add (stack2 [stack2.Count - 1]);
								stack2.RemoveAt (stack2.Count - 1);
								moving2 = false;
							}
						}
					}
				}
			
				if (one.Contains (new Point (current.X, current.Y)) && moving2) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () == stack2 [stack2.Count - 1].getColor () || (stack [stack.Count - 1].getValue () != stack2 [stack2.Count - 1].getValue () + 1)) {
							moving2 = false;
						}
					}
				}
			}
			if (stack3.Count > 0) {
				if (three.Contains (new Point (current.X, current.Y)) && moving2) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () != stack2 [stack2.Count - 1].getColor ()) {
							if (stack3 [stack3.Count - 1].getValue () == stack2 [stack2.Count - 1].getValue () + 1) {
								stack3.Add (stack2 [stack2.Count - 1]);
								stack2.RemoveAt (stack2.Count - 1);
								moving2 = false;
							}
						}
					}
				}
			}
			if (three.Contains (new Point (current.X, current.Y)) && moving2) { 
				if (current.LeftButton == ButtonState.Released) {
					if (stack3 [stack3.Count - 1].getColor () == stack2 [stack2.Count - 1].getColor ()||(stack3 [stack3.Count - 1].getValue() != stack2 [stack2.Count - 1].getValue ()+1)) {
						moving2 = false;
					}
				}
			}
			if (stack4.Count > 0) {
				if (four.Contains (new Point (current.X, current.Y)) && moving2) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () != stack2 [stack2.Count - 1].getColor ()) {
							if (stack4 [stack4.Count - 1].getValue () == stack2 [stack2.Count - 1].getValue () + 1) {
								stack4.Add (stack2 [stack2.Count - 1]);
								stack2.RemoveAt (stack2.Count - 1);
								moving2 = false;
							}
						}
					}
				}
			
				if (four.Contains (new Point (current.X, current.Y)) && moving2) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () == stack2 [stack2.Count - 1].getColor () || (stack4 [stack4.Count - 1].getValue () != stack2 [stack2.Count - 1].getValue () + 1)) {
							moving2 = false;
						}
					}
				}
			}
			if (stack5.Count > 0) {
				if (five.Contains (new Point (current.X, current.Y)) && moving2) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () != stack2 [stack2.Count - 1].getColor ()) {
							if (stack5 [stack5.Count - 1].getValue () == stack2 [stack2.Count - 1].getValue () + 1) {
								stack5.Add (stack2 [stack2.Count - 1]);
								stack2.RemoveAt (stack2.Count - 1);
								moving2 = false;
							}
						}
					}
				}
				if (five.Contains (new Point (current.X, current.Y)) && moving2) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () == stack2 [stack2.Count - 1].getColor () || (stack5 [stack5.Count - 1].getValue () != stack2 [stack2.Count - 1].getValue () + 1)) {
							moving2 = false;
						}
					}
				}
			}
			if (stack6.Count > 0) {
				if (six.Contains (new Point (current.X, current.Y)) && moving2) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () != stack2 [stack2.Count - 1].getColor ()) {
							if (stack6 [stack6.Count - 1].getValue () == stack2 [stack2.Count - 1].getValue () + 1) {
								stack6.Add (stack2 [stack2.Count - 1]);
								stack2.RemoveAt (stack2.Count - 1);
								moving2 = false;
							}
						}
					}
				}
				if (six.Contains (new Point (current.X, current.Y)) && moving2) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () == stack2 [stack2.Count - 1].getColor () || (stack6 [stack6.Count - 1].getValue () != stack2 [stack2.Count - 1].getValue () + 1)) {
							moving2 = false;
						}
					}
				}
			}
			if (stack7.Count > 0) {
				if (seven.Contains (new Point (current.X, current.Y)) && moving2) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () != stack2 [stack2.Count - 1].getColor ()) {
							if (stack7 [stack7.Count - 1].getValue () == stack2 [stack2.Count - 1].getValue () + 1) {
								stack7.Add (stack2 [stack2.Count - 1]);
								stack2.RemoveAt (stack2.Count - 1);
								moving2 = false;
							}
						}
					}
				}
				if (seven.Contains (new Point (current.X, current.Y)) && moving2) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () == stack2 [stack2.Count - 1].getColor () || (stack7 [stack7.Count - 1].getValue () != stack2 [stack2.Count - 1].getValue () + 1)) {
							moving2 = false;
						}
					}
				}
			}
			if (stack.Count > 0) {
				if (one.Contains (new Point (current.X, current.Y)) && moving3) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () != stack3 [stack3.Count - 1].getColor ()) {
							if (stack [stack.Count - 1].getValue () == stack3 [stack3.Count - 1].getValue () + 1) {
								stack.Add (stack3 [stack3.Count - 1]);
								stack3.RemoveAt (stack3.Count - 1);
								moving3 = false;
							}
						}
					}
				}
				if (one.Contains (new Point (current.X, current.Y)) && moving3) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () == stack3 [stack3.Count - 1].getColor () || (stack [stack.Count - 1].getValue () != stack3 [stack3.Count - 1].getValue () + 1)) {
							moving3 = false;
						}
					}
				}
			}
			if (stack2.Count > 0) {
				if (two.Contains (new Point (current.X, current.Y)) && moving3) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () != stack3 [stack3.Count - 1].getColor ()) {
							if (stack2 [stack2.Count - 1].getValue () == stack3 [stack3.Count - 1].getValue () + 1) {
								stack2.Add (stack3 [stack3.Count - 1]);
								stack3.RemoveAt (stack3.Count - 1);
								moving3 = false;
							}
						}
					}
				}
				if (two.Contains (new Point (current.X, current.Y)) && moving3) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () == stack3 [stack3.Count - 1].getColor () || (stack2 [stack2.Count - 1].getValue () != stack3 [stack3.Count - 1].getValue () + 1)) {
							moving3 = false;
						}
					}
				}
			}
			if (stack4.Count > 0) {
				if (four.Contains (new Point (current.X, current.Y)) && moving3) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () != stack3 [stack3.Count - 1].getColor ()) {
							if (stack4 [stack4.Count - 1].getValue () == stack3 [stack3.Count - 1].getValue () + 1) {
								stack4.Add (stack3 [stack3.Count - 1]);
								stack3.RemoveAt (stack3.Count - 1);
								moving3 = false;
							}
						}
					}
				}
				if (four.Contains (new Point (current.X, current.Y)) && moving3) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () == stack3 [stack3.Count - 1].getColor () || (stack4 [stack4.Count - 1].getValue () != stack3 [stack3.Count - 1].getValue () + 1)) {
							moving3 = false;
						}
					}
				}
			}
			if (stack5.Count > 0) {
				if (five.Contains (new Point (current.X, current.Y)) && moving3) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () != stack3 [stack3.Count - 1].getColor ()) {
							if (stack5 [stack5.Count - 1].getValue () == stack3 [stack3.Count - 1].getValue () + 1) {
								stack5.Add (stack3 [stack3.Count - 1]);
								stack3.RemoveAt (stack3.Count - 1);
								moving3 = false;
							}
						}
					}
				}
				if (five.Contains (new Point (current.X, current.Y)) && moving3) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () == stack3 [stack3.Count - 1].getColor () || (stack5 [stack5.Count - 1].getValue () != stack3 [stack3.Count - 1].getValue () + 1)) {
							moving3 = false;
						}
					}
				}
			}
			if (stack6.Count > 0) {
				if (six.Contains (new Point (current.X, current.Y)) && moving3) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () != stack3 [stack3.Count - 1].getColor ()) {
							if (stack6 [stack6.Count - 1].getValue () == stack3 [stack3.Count - 1].getValue () + 1) {
								stack6.Add (stack3 [stack3.Count - 1]);
								stack3.RemoveAt (stack3.Count - 1);
								moving3 = false;
							}
						}
					}
				}

				if (six.Contains (new Point (current.X, current.Y)) && moving3) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () == stack3 [stack3.Count - 1].getColor () || (stack6 [stack6.Count - 1].getValue () != stack3 [stack3.Count - 1].getValue () + 1)) {
							moving3 = false;
						}
					}
				}
			}
			if (stack7.Count > 0) {
				if (seven.Contains (new Point (current.X, current.Y)) && moving3) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () != stack3 [stack3.Count - 1].getColor ()) {
							if (stack7 [stack7.Count - 1].getValue () == stack3 [stack3.Count - 1].getValue () + 1) {
								stack7.Add (stack3 [stack3.Count - 1]);
								stack3.RemoveAt (stack3.Count - 1);
								moving3 = false;

							}
						}
					}
				}
				if (seven.Contains (new Point (current.X, current.Y)) && moving3) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () == stack3 [stack3.Count - 1].getColor () || (stack7 [stack7.Count - 1].getValue () != stack3 [stack3.Count - 1].getValue () + 1)) {
							moving3 = false;
						}
					}
				}
			}
			if (stack.Count > 0) {
				if (one.Contains (new Point (current.X, current.Y)) && moving4) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () != stack4 [stack4.Count - 1].getColor ()) {
							if (stack [stack.Count - 1].getValue () == stack4 [stack4.Count - 1].getValue () + 1) {
								stack.Add (stack4 [stack4.Count - 1]);
								stack4.RemoveAt (stack4.Count - 1);
								moving4 = false;
							}
						}
					}
				}
				if (one.Contains (new Point (current.X, current.Y)) && moving4) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () == stack4 [stack4.Count - 1].getColor () || (stack [stack.Count - 1].getValue () != stack4 [stack4.Count - 1].getValue () + 1)) {
							moving4 = false;
						}
					}
				}
			}
			if (stack2.Count > 0) {
				if (two.Contains (new Point (current.X, current.Y)) && moving4) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () != stack4 [stack4.Count - 1].getColor ()) {
							if (stack2 [stack2.Count - 1].getValue () == stack4 [stack4.Count - 1].getValue () + 1) {
								stack2.Add (stack4 [stack4.Count - 1]);
								stack4.RemoveAt (stack4.Count - 1);
								moving4 = false;
							}
						}
					}
				}
				if (two.Contains (new Point (current.X, current.Y)) && moving4) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () == stack4 [stack4.Count - 1].getColor () || (stack2 [stack2.Count - 1].getValue () != stack4 [stack4.Count - 1].getValue () + 1)) {
							moving4 = false;
						}
					}
				}
			}
			if (stack3.Count > 0) {
				if (three.Contains (new Point (current.X, current.Y)) && moving4) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () != stack4 [stack4.Count - 1].getColor ()) {
							if (stack3 [stack3.Count - 1].getValue () == stack4 [stack4.Count - 1].getValue () + 1) {
								stack3.Add (stack4 [stack4.Count - 1]);
								stack4.RemoveAt (stack4.Count - 1);
								moving4 = false;

							}
						}
					}
				}
				if (three.Contains (new Point (current.X, current.Y)) && moving4) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () == stack4 [stack4.Count - 1].getColor () || (stack3 [stack3.Count - 1].getValue () != stack4 [stack4.Count - 1].getValue () + 1)) {
							moving4 = false;
						}
					}
				}
			}
			if (stack5.Count > 0) {
				if (five.Contains (new Point (current.X, current.Y)) && moving4) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () != stack4 [stack4.Count - 1].getColor ()) {
							if (stack5 [stack5.Count - 1].getValue () == stack4 [stack4.Count - 1].getValue () + 1) {
								stack5.Add (stack4 [stack4.Count - 1]);
								stack4.RemoveAt (stack4.Count - 1);
								moving4 = false;
							}
						}
					}
				}
				if (five.Contains (new Point (current.X, current.Y)) && moving4) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () == stack4 [stack4.Count - 1].getColor () || (stack5 [stack5.Count - 1].getValue () != stack4 [stack4.Count - 1].getValue () + 1)) {
							moving4 = false;
						}
					}
				}
			}
			if (stack6.Count > 0) {
				if (six.Contains (new Point (current.X, current.Y)) && moving4) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () != stack4 [stack4.Count - 1].getColor ()) {
							if (stack6 [stack6.Count - 1].getValue () == stack4 [stack4.Count - 1].getValue () + 1) {
								stack6.Add (stack4 [stack4.Count - 1]);
								stack4.RemoveAt (stack4.Count - 1);
								moving4 = false;

							}
						}
					}
				}
				if (six.Contains (new Point (current.X, current.Y)) && moving4) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () == stack4 [stack4.Count - 1].getColor () || (stack6 [stack6.Count - 1].getValue () != stack4 [stack4.Count - 1].getValue () + 1)) {
							moving4 = false;
						}
					}
				}
			}
			if (stack7.Count > 0) {
				if (seven.Contains (new Point (current.X, current.Y)) && moving4) { 	
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () != stack4 [stack4.Count - 1].getColor ()) {
							if (stack7 [stack7.Count - 1].getValue () == stack4 [stack4.Count - 1].getValue () + 1) {
								stack7.Add (stack4 [stack4.Count - 1]);
								stack4.RemoveAt (stack4.Count - 1);
								moving4 = false;

							}
						}
					}
				}

				if (seven.Contains (new Point (current.X, current.Y)) && moving4) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () == stack4 [stack4.Count - 1].getColor () || (stack7 [stack7.Count - 1].getValue () != stack4 [stack4.Count - 1].getValue () + 1)) {
							moving4 = false;
						}
					}
				}
			}
			if (stack.Count > 0) {
				if (one.Contains (new Point (current.X, current.Y)) && moving5) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () != stack5 [stack5.Count - 1].getColor ()) {
							if (stack [stack.Count - 1].getValue () == stack5 [stack5.Count - 1].getValue () + 1) {
								stack.Add (stack5 [stack5.Count - 1]);
								stack5.RemoveAt (stack5.Count - 1);
								moving5 = false;

							}
						}
					}
				} 
				if (one.Contains (new Point (current.X, current.Y)) && moving5) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () == stack5 [stack5.Count - 1].getColor () || (stack [stack.Count - 1].getValue () != stack5 [stack5.Count - 1].getValue () + 1)) {
							moving5 = false;
						}
					}
				}
			}
			

			if (stack2.Count > 0) {
				if (two.Contains (new Point (current.X, current.Y)) && moving5) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () != stack5 [stack5.Count - 1].getColor ()) {
							if (stack2 [stack2.Count - 1].getValue () == stack5 [stack5.Count - 1].getValue () + 1) {
								stack2.Add (stack5 [stack5.Count - 1]);
								stack5.RemoveAt (stack5.Count - 1);
								moving5 = false;

							}
						}
					}
				}
				if (two.Contains (new Point (current.X, current.Y)) && moving5) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () == stack5 [stack5.Count - 1].getColor () || stack2 [stack2.Count - 1].getValue () != stack5 [stack5.Count - 1].getValue () + 1) {
							moving5 = false;
						}
					}
				}
			}


			if (stack3.Count > 0) {
				if (three.Contains (new Point (current.X, current.Y)) && moving5) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () != stack5 [stack5.Count - 1].getColor ()) {
							if (stack3 [stack3.Count - 1].getValue () == stack5 [stack5.Count - 1].getValue () + 1) {
								stack3.Add (stack5 [stack5.Count - 1]);
								stack5.RemoveAt (stack5.Count - 1);
								moving5 = false;

							}
						}
					}
				}
				if (three.Contains (new Point (current.X, current.Y)) && moving5) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () == stack5 [stack5.Count - 1].getColor () || stack3 [stack3.Count - 1].getValue () != stack5 [stack5.Count - 1].getValue () + 1) {

							moving5 = false;
						}
					}
				}
			}
			if (stack4.Count > 0) {
				if (four.Contains (new Point (current.X, current.Y)) && moving5) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () != stack5 [stack5.Count - 1].getColor ()) {
							if (stack4 [stack4.Count - 1].getValue () == stack5 [stack5.Count - 1].getValue () + 1) {
								stack4.Add (stack5 [stack5.Count - 1]);
								stack5.RemoveAt (stack5.Count - 1);
								moving5 = false;

							}
						}
					}
				}
				if (four.Contains (new Point (current.X, current.Y)) && moving5) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () == stack5 [stack5.Count - 1].getColor () || stack4 [stack4.Count - 1].getValue () != stack5 [stack5.Count - 1].getValue () + 1) {
							moving5 = false;
						}
					}
				}
			}


			if (stack6.Count > 0) {
				if (six.Contains (new Point (current.X, current.Y)) && moving5) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () != stack5 [stack5.Count - 1].getColor ()) {
							if (stack6 [stack6.Count - 1].getValue () == stack5 [stack5.Count - 1].getValue () + 1) {
								stack6.Add (stack5 [stack5.Count - 1]);
								stack5.RemoveAt (stack5.Count - 1);
								moving5 = false;
							}
						}
					}
				}

				if (six.Contains (new Point (current.X, current.Y)) && moving5) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () == stack5 [stack5.Count - 1].getColor () || stack6 [stack6.Count - 1].getValue () != stack5 [stack5.Count - 1].getValue () + 1) {
							moving5 = false;
						}
					}
				}
			}
			if (stack7.Count > 0) {
				if (seven.Contains (new Point (current.X, current.Y)) && moving5) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () != stack5 [stack5.Count - 1].getColor ()) {
							if (stack7 [stack7.Count - 1].getValue () == stack5 [stack5.Count - 1].getValue () + 1) {
								stack7.Add (stack5 [stack5.Count - 1]);
								stack5.RemoveAt (stack5.Count - 1);
								moving5 = false;

							}
						}
					}
				}

				if (seven.Contains (new Point (current.X, current.Y)) && moving5) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () == stack5 [stack5.Count - 1].getColor () || stack7 [stack7.Count - 1].getValue () != stack5 [stack5.Count - 1].getValue () + 1) {
							moving5 = false;
						}
					}
				}
			}
			if (stack.Count > 0) {
				if (one.Contains (new Point (current.X, current.Y)) && moving6) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () != stack6 [stack6.Count - 1].getColor ()) {
							if (stack [stack.Count - 1].getValue () == stack6 [stack6.Count - 1].getValue () + 1) {
								stack.Add (stack6 [stack6.Count - 1]);
								stack6.RemoveAt (stack6.Count - 1);
								moving6 = false;

							}
						}
					}
				}
			
				if (one.Contains (new Point (current.X, current.Y)) && moving6) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () == stack6 [stack6.Count - 1].getColor () || stack [stack.Count - 1].getValue () != stack6 [stack6.Count - 1].getValue () + 1) {
							moving6 = false;
						}
					}
				}
			}
			if (stack2.Count > 0) {
				if (two.Contains (new Point (current.X, current.Y)) && moving6) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () != stack6 [stack6.Count - 1].getColor ()) {
							if (stack2 [stack2.Count - 1].getValue () == stack6 [stack6.Count - 1].getValue () + 1) {
								stack2.Add (stack6 [stack6.Count - 1]);
								stack6.RemoveAt (stack6.Count - 1);
								moving6 = false;

							}
						}
					}
				}
			
				if (two.Contains (new Point (current.X, current.Y)) && moving6) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () == stack6 [stack6.Count - 1].getColor () || stack2 [stack2.Count - 1].getValue () != stack6 [stack6.Count - 1].getValue () + 1) {
							moving6 = false;
						}
					}
				}
			}
			if (stack3.Count > 0) {
				if (three.Contains (new Point (current.X, current.Y)) && moving6) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () != stack6 [stack6.Count - 1].getColor ()) {
							if (stack3 [stack3.Count - 1].getValue () == stack6 [stack6.Count - 1].getValue () + 1) {
								stack3.Add (stack6 [stack6.Count - 1]);
								stack6.RemoveAt (stack6.Count - 1);
								moving6 = false;

							}
						}
					}
				}

				if (three.Contains (new Point (current.X, current.Y)) && moving6) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () == stack6 [stack6.Count - 1].getColor () || stack3 [stack3.Count - 1].getValue () != stack6 [stack6.Count - 1].getValue () + 1) {
							moving6 = false;
						}
					}
				}
			}
			if (stack4.Count > 0) {
				if (four.Contains (new Point (current.X, current.Y)) && moving6) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () != stack6 [stack6.Count - 1].getColor ()) {
							if (stack4 [stack4.Count - 1].getValue () == stack6 [stack6.Count - 1].getValue () + 1) {
								stack4.Add (stack6 [stack6.Count - 1]);
								stack6.RemoveAt (stack6.Count - 1);
								moving6 = false;

							}
						}
					}
				}
				if (four.Contains (new Point (current.X, current.Y)) && moving6) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () == stack6 [stack6.Count - 1].getColor () || stack4 [stack4.Count - 1].getValue () != stack6 [stack6.Count - 1].getValue () + 1) {
							moving6 = false;
						}
					}
				}
			}
			if (stack5.Count > 0) {
				if (five.Contains (new Point (current.X, current.Y)) && moving6) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () != stack6 [stack6.Count - 1].getColor ()) {
							if (stack5 [stack5.Count - 1].getValue () == stack6 [stack6.Count - 1].getValue () + 1) {
								stack5.Add (stack6 [stack6.Count - 1]);
								stack6.RemoveAt (stack6.Count - 1);
								moving6 = false;

							}
						}
					}
				}
				if (five.Contains (new Point (current.X, current.Y)) && moving6) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () == stack6 [stack6.Count - 1].getColor () || stack5 [stack5.Count - 1].getValue () != stack6 [stack6.Count - 1].getValue () + 1) {
							moving6 = false;
						}
					}
				}
			}
			if (stack7.Count > 0) {
				if (seven.Contains (new Point (current.X, current.Y)) && moving6) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () != stack6 [stack6.Count - 1].getColor ()) {
							if (stack7 [stack7.Count - 1].getValue () == stack6 [stack6.Count - 1].getValue () + 1) {
								stack7.Add (stack6 [stack6.Count - 1]);
								stack6.RemoveAt (stack6.Count - 1);
								moving6 = false;

							}
						}
					}
				}
				if (seven.Contains (new Point (current.X, current.Y)) && moving6) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack7 [stack7.Count - 1].getColor () == stack6 [stack6.Count - 1].getColor () || stack7 [stack7.Count - 1].getValue () != stack6 [stack6.Count - 1].getValue () + 1) {
							moving6 = false;
						}
					}
				}
			}

			if (stack.Count > 0) {
				if (one.Contains (new Point (current.X, current.Y)) && moving7) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () != stack7 [stack7.Count - 1].getColor ()) {
							if (stack [stack.Count - 1].getValue () == stack7 [stack7.Count - 1].getValue () + 1) {
								stack.Add (stack7 [stack7.Count - 1]);
								stack7.RemoveAt (stack7.Count - 1);
								moving7 = false;

							}
						}
					}
				}
				if (one.Contains (new Point (current.X, current.Y)) && moving7) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack [stack.Count - 1].getColor () == stack7 [stack7.Count - 1].getColor () || stack [stack.Count - 1].getValue () != stack7 [stack7.Count - 1].getValue () + 1) {
							moving7 = false;
						}
					}
				}
			}
						
			if (stack2.Count > 0) {
				if (two.Contains (new Point (current.X, current.Y)) && moving7) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () != stack7 [stack7.Count - 1].getColor ()) {
							if (stack2 [stack2.Count - 1].getValue () == stack7 [stack7.Count - 1].getValue () + 1) {
								stack2.Add (stack7 [stack7.Count - 1]);
								stack7.RemoveAt (stack7.Count - 1);
								moving7 = false;
							}
						}
					}
				}
				if (two.Contains (new Point (current.X, current.Y)) && moving7) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack2 [stack2.Count - 1].getColor () == stack7 [stack7.Count - 1].getColor () || stack2 [stack2.Count - 1].getValue () != stack7 [stack7.Count - 1].getValue () + 1) {
							moving7 = false;
						}
					}
				}
			}
			if (stack3.Count > 0) {
				if (three.Contains (new Point (current.X, current.Y)) && moving7) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () != stack7 [stack7.Count - 1].getColor ()) {
							if (stack3 [stack3.Count - 1].getValue () == stack7 [stack7.Count - 1].getValue () + 1) {
								stack3.Add (stack7 [stack7.Count - 1]);
								stack7.RemoveAt (stack7.Count - 1);
								moving7 = false;

							}
						}
					}
				}

				if (three.Contains (new Point (current.X, current.Y)) && moving7) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack3 [stack3.Count - 1].getColor () == stack7 [stack7.Count - 1].getColor () || stack3 [stack3.Count - 1].getValue () != stack7 [stack7.Count - 1].getValue () + 1) {
							moving7 = false;
						}
					}
				}
			}
			if (stack4.Count > 0) {
				if (four.Contains (new Point (current.X, current.Y)) && moving7) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () != stack7 [stack7.Count - 1].getColor ()) {
							if (stack4 [stack4.Count - 1].getValue () == stack7 [stack7.Count - 1].getValue () + 1) {
								stack4.Add (stack7 [stack.Count - 1]);
								stack7.RemoveAt (stack7.Count - 1);
								moving7 = false;

							}
						}
					}
				}
				if (four.Contains (new Point (current.X, current.Y)) && moving7) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack4 [stack4.Count - 1].getColor () == stack7 [stack7.Count - 1].getColor () || stack4 [stack4.Count - 1].getValue () != stack7 [stack7.Count - 1].getValue () + 1) {
							moving7 = false;
						}
					}
				}
			}
			if (stack5.Count > 0) {
				if (five.Contains (new Point (current.X, current.Y)) && moving7) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () != stack7 [stack7.Count - 1].getColor ()) {
							if (stack5 [stack5.Count - 1].getValue () == stack7 [stack7.Count - 1].getValue () + 1) {
								stack5.Add (stack7 [stack.Count - 1]);
								stack7.RemoveAt (stack7.Count - 1);
								moving7 = false;
							}
						}
					}
				}
				if (five.Contains (new Point (current.X, current.Y)) && moving7) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack5 [stack5.Count - 1].getColor () == stack7 [stack7.Count - 1].getColor () || stack5 [stack5.Count - 1].getValue () != stack7 [stack7.Count - 1].getValue () + 1) {
							moving7 = false;
						}
					}
				}
			}
			if (stack6.Count > 0) {
				if (six.Contains (new Point (current.X, current.Y)) && moving7) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () != stack7 [stack7.Count - 1].getColor ()) {
							if (stack6 [stack6.Count - 1].getValue () == stack7 [stack7.Count - 1].getValue () + 1) {
								stack6.Add (stack7 [stack7.Count - 1]);
								stack7.RemoveAt (stack7.Count - 1);
								moving7 = false;
							}
						}
					}
				}
				if (six.Contains (new Point (current.X, current.Y)) && moving7) { 
					if (current.LeftButton == ButtonState.Released) {
						if (stack6 [stack6.Count - 1].getColor () == stack7 [stack7.Count - 1].getColor () || stack6 [stack6.Count - 1].getValue () != stack7 [stack7.Count - 1].getValue () + 1) {
							moving7 = false;
						}
					}
				}
			}
				putOnAce ();
		}
			
		/// <summary>
		/// The following methdod defines each card and the location of the card on the sprite sheet
		/// </summary>
		public void cards()
		{
			
			twoOfHearts = new Rectangle (0, 0, width, height);
			threeOfHearts = new Rectangle ((1*width), (0*height), width, height);
			fourOfHearts = new Rectangle ((2*width), (0*height), width, height);
			fiveOfHearts = new Rectangle ((3*width), (0*height), width, height);
			sixOfHearts = new Rectangle  ((4*width), (0*height), width, height);
			sevenOfHearts = new Rectangle ((5*width), (0*height), width, height);
			eightOfHearts = new Rectangle ((6*width), (0*height), width, height);
			nineOfHearts = new Rectangle ((7*width), (0*height), width, height);
			tenOfHearts = new Rectangle ((8 * width), (0 * height), width, height);
			jackOfHearts = new Rectangle ((9 * width), (0 * height), width, height);
			queenOfHearts = new Rectangle ((10 * width), (0 * height), width, height);
			kingOfHearts = new Rectangle ((11 * width), (0 * height), width, height);
			aceOfHearts = new Rectangle ((12 * width), (0 * height), width, height);
			twoOfClubs = new Rectangle (0, height*2, width, height);
			threeOfClubs = new Rectangle ((1*width), (2*height), width, height);
			fourOfClubs = new Rectangle ((2*width), (2*height), width, height);
			fiveOfClubs = new Rectangle ((3*width), (2*height), width, height);
			sixOfClubs = new Rectangle  ((4*width), (2*height), width, height);
			sevenOfClubs = new Rectangle ((5*width), (2*height), width, height);
			eightOfClubs = new Rectangle ((6*width), (2*height), width, height);
			nineOfClubs = new Rectangle ((7*width), (2*height), width, height);
			tenOfClubs = new Rectangle ((8 * width), (2*height), width, height);
			jackOfClubs = new Rectangle ((9 * width), (2*height), width, height);
			queenOfClubs = new Rectangle ((10 * width), (2*height), width, height);
			kingOfClubs = new Rectangle ((11 * width), (2*height), width, height);
			aceOfClubs = new Rectangle ((12 * width), (2*height), width, height);
			twoOfDiamonds = new Rectangle (0, (height), width, height);
			threeOfDiamonds = new Rectangle ((1*width), (height), width, height);
			fourOfDiamonds = new Rectangle ((2*width), (height), width, height);
			fiveOfDiamonds = new Rectangle ((3*width), (height), width, height);
			sixOfDiamonds = new Rectangle  ((4*width), (height), width, height);
			sevenOfDiamonds = new Rectangle ((5*width), (height), width, height);
			eightOfDiamonds = new Rectangle ((6*width), (height), width, height);
			nineOfDiamonds = new Rectangle ((7*width), (height), width, height);
			tenOfDiamonds = new Rectangle ((8 * width), (height), width, height);
			jackOfDiamonds = new Rectangle ((9 * width), (height), width, height);
			queenOfDiamonds = new Rectangle ((10 * width), (height), width, height);
			kingOfDiamonds = new Rectangle ((11 * width), (height), width, height);
			aceOfDiamonds = new Rectangle ((12 * width), (height), width, height);
			twoOfSpades = new Rectangle (0, (3* height), width, height);
			threeOfSpades = new Rectangle ((1*width), (3*height), width, height);
			fourOfSpades = new Rectangle ((2*width), (3*height), width, height);
			fiveOfSpades = new Rectangle ((3*width), (3*height), width, height);
			sixOfSpades = new Rectangle  ((4*width), (3*height), width, height);
			sevenOfSpades = new Rectangle ((5*width), (3*height), width, height);
			eightOfSpades = new Rectangle ((6*width), (3*height), width, height);
			nineOfSpades = new Rectangle ((7*width), (3*height), width, height);
			tenOfSpades = new Rectangle ((8 * width), (3 * height), width, height);
			jackOfSpades = new Rectangle ((9 * width), (3 * height), width, height);
			queenOfSpades = new Rectangle ((10 * width), (3 * height), width, height);
			kingOfSpades = new Rectangle ((11 * width), (3 * height), width, height);
			aceOfSpades = new Rectangle ((12 * width), (3 * height), width, height);
			// below we put the cards above into the deck array, in addition we assign

			deck [0] = new cards (1,1, 1, aceOfSpades);
			deck [1] = new cards (1,1, 2, twoOfSpades);
			deck [2] = new cards (1,1, 3, threeOfSpades);
			deck [3] = new cards (1,1, 4, fourOfSpades);
			deck [4] = new cards (1,1, 5, fiveOfSpades);
			deck [5] = new cards (1,1, 6, sixOfSpades);
			deck [6] = new cards (1,1, 7, sevenOfSpades);
			deck [7] = new cards (1,1, 8, eightOfSpades);
			deck [8] = new cards (1,1, 9, nineOfSpades);
			deck [9] = new cards (1,1, 10, tenOfSpades);
			deck [10] = new cards (1,1, 11, jackOfSpades);
			deck [11] = new cards (1,1, 12, queenOfSpades);
			deck [12] = new cards (1,1, 13, kingOfSpades);
			deck [13] = new cards (2,2, 1, aceOfDiamonds);
			deck [14] = new cards (2,2, 2, twoOfDiamonds);
			deck [15] = new cards (2,2, 3, threeOfDiamonds);
			deck [16] = new cards (2,2, 4, fourOfDiamonds);
			deck [17] = new cards (2,2, 5, fiveOfDiamonds);
			deck [18] = new cards (2,2, 6, sixOfDiamonds);
			deck [19] = new cards (2,2, 7, sevenOfDiamonds);
			deck [20] = new cards (2,2, 8, eightOfDiamonds);
			deck [21] = new cards (2,2, 9, nineOfDiamonds);
			deck [22] = new cards (2,2, 10, tenOfDiamonds);
			deck [23] = new cards (2,2, 11, jackOfDiamonds);
			deck [24] = new cards (2,2, 12, queenOfDiamonds);
			deck [25] = new cards (2,2, 13, kingOfDiamonds);
			deck [26] = new cards (1,3, 1, aceOfClubs);
			deck [27] = new cards (1,3, 2, twoOfClubs);
			deck [28] = new cards (1,3, 3, threeOfClubs);
			deck [29] = new cards (1,3, 4, fourOfClubs);
			deck [30] = new cards (1,3, 5, fiveOfClubs);
			deck [31] = new cards (1,3, 6, sixOfClubs);
			deck [32] = new cards (1,3, 7, sevenOfClubs);
			deck [33] = new cards (1,3, 8, eightOfClubs);
			deck [34] = new cards (1,3, 9, nineOfClubs);
			deck [35] = new cards (1,3, 10, tenOfClubs);
			deck [36] = new cards (1,3, 11, jackOfClubs);
			deck [37] = new cards (1,3, 12, queenOfClubs);
			deck [38] = new cards (1,3, 13, kingOfClubs);
			deck [39] = new cards (2,4, 1, aceOfHearts);
			deck [40] = new cards (2,4, 2, twoOfHearts);
			deck [41] = new cards (2,4, 3, threeOfHearts);
			deck [42] = new cards (2,4, 4, fourOfHearts);
			deck [43] = new cards (2,4, 5, fiveOfHearts);
			deck [44] = new cards (2,4, 6, sixOfHearts);
			deck [45] = new cards (2,4, 7, sevenOfHearts);
			deck [46] = new cards (2,4, 8, eightOfHearts);
			deck [47] = new cards (2,4, 9, nineOfHearts);
			deck [48] = new cards (2,4, 10, tenOfHearts);
			deck [49] = new cards (2,4, 11, jackOfHearts);
			deck [50] = new cards (2,4, 12, queenOfHearts);
			deck [51] = new cards (2,4, 13, kingOfHearts);
			}

		public void shuffle (){
			
		for (int i = 0; i < 100000; i++)
			{ 
				Random random = new Random();
				int a = (int)(random.Next(0,51));
				int b = (int)(random.Next(0,51));
				cards temp = deck[a];
				deck [a] = deck[b];
				deck[b] = temp;
			}
		}


		public void moving (){
			
			for (int i = 0; i < stack.Count; i++) {
				if (current.LeftButton == ButtonState.Pressed) {
					if (one.Contains (new Point (current.X, current.Y)) && !onCard2 && !onCard3 && !onCard4 && !onCard5 && !onCard6 && !onCard7 && !onCard8) {
						if (stack.Count > 0) {
							firstSlot1.X = (int)(current.X - movingLocation1.X);
							firstSlot1.Y = (int)(current.Y - movingLocation1.Y - i * 30);
							onCard1 = true;
						}
					} 
				} else {
					onCard1 = false;
				}
			}
			if (one.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					moving1 = false;
				}
			}
			if (two.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					moving2 = false;
				}
			}
			if (three.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					moving3 = false;
				}
			}
			if (four.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					moving4 = false;
				}
			}
			if (five.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					moving5 = false;
				}
			}
			if (six.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					moving6 = false;
				}
			}
			if (seven.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					moving7 = false;
				}
			}
			if (eight.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					moving8 = false;
				}
			}		
			if (one.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					movingMult1 = false;
				}
			}
			if (two.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					movingMult2 = false;
				}
			}
			if (three.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					movingMult3 = false;
				}
			}
			if (four.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					movingMult4 = false;
				}
			}
			if (five.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					movingMult5 = false;
				}
			}
			if (six.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					movingMult6 = false;
				}
			}
			if (seven.Contains (new Point (current.X, current.Y))) {
				if (current.LeftButton == ButtonState.Released) {
					movingMult7 = false;
				}
			}
			for (int i = 0; i < stack2.Count; i++) {
				if (current.LeftButton == ButtonState.Pressed) {
					if (two.Contains (new Point (current.X, current.Y)) && !onCard1 && !onCard3 && !onCard4 && !onCard5 && !onCard6 && !onCard7 && !onCard8) {
						if (stack2.Count > 0) {
							secondSlot1.X = (int)(current.X - movingLocation2.X);
							secondSlot1.Y = (int)(current.Y - movingLocation2.Y - i * 30);
							onCard2 = true;
						}
					}
				} else {
					onCard2 = false;
				}
			}
			for (int i = 0; i < stack3.Count; i++) {
				if (current.LeftButton == ButtonState.Pressed) {
					if (three.Contains (new Point (current.X, current.Y)) && !onCard2 && !onCard1 && !onCard4 && !onCard5 && !onCard6 && !onCard7 && !onCard8) {
						if (stack3.Count > 0) {
							thirdSlot1.X = (int)(current.X - movingLocation3.X);
							thirdSlot1.Y = (int)(current.Y - movingLocation3.Y - i * 30);
							onCard3 = true;

						}
					}
				} else {
					onCard3 = false;
				}
			}
			for (int i = 0; i < stack4.Count; i++) {
				if (current.LeftButton == ButtonState.Pressed) {
					if (four.Contains (new Point (current.X, current.Y)) && !onCard2 && !onCard3 && !onCard1 && !onCard5 && !onCard6 && !onCard7 && !onCard8) {
						if (stack4.Count > 0) {
							fourthSlot1.X = (int)(current.X - movingLocation4.X);
							fourthSlot1.Y = (int)(current.Y - movingLocation4.Y - i * 30);
							onCard4 = true;

						}
					}
				} else {
					onCard4 = false;
				}
			}	
			for (int i = 0; i < stack5.Count; i++) {
				if (current.LeftButton == ButtonState.Pressed) {
					if (five.Contains (new Point (current.X, current.Y)) && !onCard2 && !onCard3 && !onCard4 && !onCard1 && !onCard6 && !onCard7 && !onCard8) {
						if (stack5.Count > 0) {
							fifthSlot1.X = (int)(current.X - movingLocation5.X);
							fifthSlot1.Y = (int)(current.Y - movingLocation5.Y - i * 30);
							onCard5 = true;

						}
					}
				} else {
					onCard5 = false;
				}
			}
			for (int i = 0; i < stack6.Count; i++) {
				if (current.LeftButton == ButtonState.Pressed) {
					if (six.Contains (new Point (current.X, current.Y)) && !onCard2 && !onCard3 && !onCard4 && !onCard5 && !onCard1 && !onCard7 && !onCard8) {
						if (stack6.Count > 0) {
							sixthSlot1.X = (int)(current.X - movingLocation6.X);
							sixthSlot1.Y = (int)(current.Y - movingLocation6.Y - i * 30);
							onCard6 = true;

						}
					}
				} else {
					onCard6 = false;
				}
			}	
			for (int i = 0; i < stack7.Count; i++) {
				if (current.LeftButton == ButtonState.Pressed) {
					if (seven.Contains (new Point (current.X, current.Y)) && !onCard2 && !onCard3 && !onCard4 && !onCard5 && !onCard6 && !onCard1 && !onCard8) {
						if (stack7.Count > 0) {
							seventhSlot1.X = (int)(current.X - movingLocation7.X);
							seventhSlot1.Y = (int)(current.Y - movingLocation7.Y - i * 30);
							onCard7 = true;

						}
					}
				} else {
					onCard7 = false;
				}
			}
			for (int i = 0; i < pile.Count; i++) {
				if (current.LeftButton == ButtonState.Pressed) {
					if (eight.Contains (new Point (current.X, current.Y)) && !onCard7 && !onCard2 && !onCard3 && !onCard4 && !onCard5 && !onCard6 && !onCard1) {
						if (pile.Count > 0) {
							eighthSlot1.X = (int)(current.X - pileLocation.X);
							eighthSlot1.Y = (int)(current.Y - pileLocation.Y);
							onCard8 = true;

						}
					}
				} else {
					onCard8 = false;
				}
			}
			if (onCard1) {
				if (movingCards.Count > 0) {
					for (int i = 0; i < movingCards.Count; i++) {
						cards c = (cards)movingCards [i];
						movingLocation1.X = (current.X - firstSlot1.X);
						movingLocation1.Y = (current.Y - firstSlot1.Y); 
						spriteBatch.Draw (playingCards, new Vector2 (movingLocation1.X, movingLocation1.Y + i * 30), c.getSource (), Color.White);
						movingMult1 = true;
					}
				}
				if (movingCards.Count == 0) {
					cards c = (cards)stack [stack.Count - 1];
					movingLocation1.X = (current.X - firstSlot1.X);
					movingLocation1.Y = (current.Y - firstSlot1.Y); 
					spriteBatch.Draw (playingCards, new Vector2 (movingLocation1.X, movingLocation1.Y), c.getSource (), Color.White);
					moving1 = true;
				}
			}
			if (onCard2) {
				if (movingCards.Count > 0) {
					for (int i = 0; i < movingCards.Count; i++) {
						cards c = (cards)movingCards [i];
						movingLocation2.X = (current.X - secondSlot1.X);
						movingLocation2.Y = (current.Y - secondSlot1.Y); 
						spriteBatch.Draw (playingCards, new Vector2 (movingLocation2.X, movingLocation2.Y + i * 30), c.getSource (), Color.White);
						movingMult2 = true;
					}
				}
				if (movingCards.Count == 0) {
					cards c = (cards)stack2 [stack2.Count - 1];
					movingLocation2.X = (current.X - secondSlot1.X);
					movingLocation2.Y = (current.Y - secondSlot1.Y); 
					spriteBatch.Draw (playingCards, new Vector2 (movingLocation2.X, movingLocation2.Y), c.getSource (), Color.White);
					moving2 = true;
				}
			}
			if (onCard3) {
				if (movingCards.Count > 0) {
					for (int i = 0; i < movingCards.Count; i++) {
						cards c = (cards)movingCards [i];
						movingLocation3.X = (current.X - thirdSlot1.X);
						movingLocation3.Y = (current.Y - thirdSlot1.Y); 
						spriteBatch.Draw (playingCards, new Vector2 (movingLocation3.X, movingLocation3.Y + i * 30), c.getSource (), Color.White);
						movingMult3 = true;
					}
				}
				if (movingCards.Count == 0) {
					cards c = (cards)stack3 [stack3.Count - 1];
					movingLocation3.X = (current.X - thirdSlot1.X);
					movingLocation3.Y = (current.Y - thirdSlot1.Y); 
					spriteBatch.Draw (playingCards, new Vector2 (movingLocation3.X, movingLocation3.Y), c.getSource (), Color.White);
					moving3 = true;
				}
			}
			if (onCard4) {
				if (movingCards.Count > 0) {
					for (int i = 0; i < movingCards.Count; i++) {
						cards c = (cards)movingCards [i];
						movingLocation4.X = (current.X - fourthSlot1.X);
						movingLocation4.Y = (current.Y - fourthSlot1.Y); 
						spriteBatch.Draw (playingCards, new Vector2 (movingLocation4.X, movingLocation4.Y + i * 30), c.getSource (), Color.White);
						movingMult4 = true;
					}
				}
				if (movingCards.Count == 0) {
					cards c = (cards)stack4 [stack4.Count - 1];
					movingLocation4.X = (current.X - fourthSlot1.X);
					movingLocation4.Y = (current.Y - fourthSlot1.Y); 
					spriteBatch.Draw (playingCards, new Vector2 (movingLocation4.X, movingLocation4.Y), c.getSource (), Color.White);
					moving4 = true;
				}
			}
			if (onCard5) {
				if (movingCards.Count > 0) {
					for (int i = 0; i < movingCards.Count; i++) {
						cards c = (cards)movingCards [i];
						movingLocation5.X = (current.X - fifthSlot1.X);
						movingLocation5.Y = (current.Y - fifthSlot1.Y); 
						spriteBatch.Draw (playingCards, new Vector2 (movingLocation5.X, movingLocation5.Y + i * 30), c.getSource (), Color.White);
						movingMult5 = true;
					}
				}
				if (movingCards.Count == 0) {
					cards c = (cards)stack5 [stack5.Count - 1];
					movingLocation5.X = (current.X - fifthSlot1.X);
					movingLocation5.Y = (current.Y - fifthSlot1.Y); 
					spriteBatch.Draw (playingCards, new Vector2 (movingLocation5.X, movingLocation5.Y), c.getSource (), Color.White);
					moving5 = true;
				}
			}
			if (onCard6) {
				if (movingCards.Count > 0) {
					for (int i = 0; i < movingCards.Count; i++) {
						cards c = (cards)movingCards [i];
						movingLocation6.X = (current.X - sixthSlot1.X);
						movingLocation6.Y = (current.Y - sixthSlot1.Y); 
						spriteBatch.Draw (playingCards, new Vector2 (movingLocation6.X, movingLocation6.Y + i * 30), c.getSource (), Color.White);
						movingMult6 = true;
					}
				}
				if (movingCards.Count == 0) {
					cards c = (cards)stack6 [stack6.Count - 1];
					movingLocation6.X = (current.X - sixthSlot1.X);
					movingLocation6.Y = (current.Y - sixthSlot1.Y); 
					spriteBatch.Draw (playingCards, new Vector2 (movingLocation6.X, movingLocation6.Y), c.getSource (), Color.White);
					moving6 = true;
				}
			}
			if (onCard7) {
				if (movingCards.Count > 0) {
					for (int i = 0; i < movingCards.Count; i++) {
						cards c = (cards)movingCards [i];
						movingLocation7.X = (current.X - seventhSlot1.X);
						movingLocation7.Y = (current.Y - seventhSlot1.Y); 
						spriteBatch.Draw (playingCards, new Vector2 (movingLocation7.X, movingLocation7.Y + i * 30), c.getSource (), Color.White);
						movingMult7 = true;
					}
				}
				if (movingCards.Count == 0) {
					cards c = (cards)stack7 [stack7.Count - 1];
					movingLocation7.X = (current.X - seventhSlot1.X);
					movingLocation7.Y = (current.Y - seventhSlot1.Y); 
					spriteBatch.Draw (playingCards, new Vector2 (movingLocation7.X, movingLocation7.Y), c.getSource (), Color.White);
					moving7 = true;
				}
			}
			if (onCard8 && pile.Count != 0) {
				cards c = (cards)pile [pile.Count - 1];
				pileLocation.X = (current.X - eighthSlot1.X);
				pileLocation.Y = (current.Y - eighthSlot1.Y); 
				spriteBatch.Draw (playingCards, pileLocation, c.getSource (), Color.White);
				moving8 = true;
			}
	
		}
		public void	movingMultipleCards (){

			for (int i = 0; i < movingCards.Count; i++) {
				if ( Keyboard.GetState ().IsKeyDown (Keys.Space)) {
					movingCards.Remove (movingCards [i]);
				}
			}
			if (!moving2 && !moving3 && !moving4 && !moving5 && !moving6 && !moving7) {
				for (int i = 0; i < stack.Count; i++) {
					if (stackTopSection.Contains (new Point (current.X, current.Y))) {
						if (current.LeftButton == ButtonState.Pressed) {

							if (movingCards.Count < stack.Count) {
								movingCards.Add (stack [i]);
							}
						}
					}
				}
			}
			if (!moving1 && !moving3 && !moving4 && !moving5 && !moving6 && !moving7) {
				for (int i = 0; i < stack2.Count; i++) {
					if (stack2TopSection.Contains (new Point (current.X, current.Y))) {
						if (stack2 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack2.Count) {
									movingCards.Add (stack2 [i]);
								}
							}
						}

					}
				}
				for (int i = 1; i < stack2.Count; i++) {
					if (stack2SecondSection.Contains (new Point (current.X, current.Y))) {
						if (!stack2 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack2.Count - 1) {
									movingCards.Add (stack2 [i]);
								}
							}
						}

					}
				}
			}
			if (!moving1 && !moving2 && !moving4 && !moving5 && !moving6 && !moving7) {
				for (int i = 0; i < stack3.Count; i++) {
					if (stack3TopSection.Contains (new Point (current.X, current.Y))) {
						if (stack3 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {


							}
						}

					}
				}
				for (int i = 1; i < stack3.Count; i++) {
					if (stack3SecondSection.Contains (new Point (current.X, current.Y))) {
						if (stack3 [1].isShowing () && !stack3 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack3.Count - 1) {
									movingCards.Add (stack3 [i]);
								}
							}
						}

					}
				}
				for (int i = 2; i < stack3.Count; i++) {
					if (stack3ThirdSection.Contains (new Point (current.X, current.Y))) {
						if (!stack3 [1].isShowing () && !stack3 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack3.Count - 2) {
									movingCards.Add (stack3 [i]);
								}
							}
						}

					}
				}
			}
			if (!moving1 && !moving3 && !moving2 && !moving5 && !moving6 && !moving7) {
				for (int i = 0; i < stack4.Count; i++) {
					if (stack4TopSection.Contains (new Point (current.X, current.Y))) {
						if (stack4 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack4.Count) {
									movingCards.Add (stack4 [i]);
								}
							}
						}

					}
				}
				for (int i = 1; i < stack4.Count; i++) {
					if (stack4SecondSection.Contains (new Point (current.X, current.Y))) {
						if (stack4 [1].isShowing () && !stack4 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack4.Count - 1) {
									movingCards.Add (stack4 [i]);
								}
							}
						}

					}
				}
				for (int i = 2; i < stack4.Count; i++) {
					if (stack4ThirdSection.Contains (new Point (current.X, current.Y))) {
						if (stack4 [2].isShowing () && !stack4 [1].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack4.Count - 2) {
									movingCards.Add (stack4 [i]);
								}
							}
						}

					}
				}
				for (int i = 3; i < stack4.Count; i++) {
					if (stack4FourthSection.Contains (new Point (current.X, current.Y))) {
						if (!stack4 [2].isShowing () && !stack4 [1].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack4.Count - 3) {
									movingCards.Add (stack4 [i]);
								}
							}
						}

					}
				}
			}

			if (!moving1 && !moving3 && !moving4 && !moving2 && !moving6 && !moving7) {
				for (int i = 0; i < stack5.Count; i++) {
					if (stack5TopSection.Contains (new Point (current.X, current.Y))) {
						if (stack5 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack5.Count) {
									movingCards.Add (stack5 [i]);
								}
							}
						}

					}

				}
				for (int i = 1; i < stack5.Count; i++) {
					if (stack5SecondSection.Contains (new Point (current.X, current.Y))) {
						if (stack5 [1].isShowing () && !stack5 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {
								if (movingCards.Count < stack5.Count - 1) {
									movingCards.Add (stack5 [i]);
								}

							}
						}
					}

				}

				for (int i = 2; i < stack5.Count; i++) {
					if (stack5ThirdSection.Contains (new Point (current.X, current.Y))) {
						if (stack5 [2].isShowing () && !stack5 [1].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack5.Count - 2) {
									movingCards.Add (stack5 [i]);
								}
							}
						}
					}
				}
				for (int i = 3; i < stack5.Count; i++) {
					if (stack5FourthSection.Contains (new Point (current.X, current.Y))) {
						if (stack5 [3].isShowing () && !stack5 [2].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack5.Count - 3) {
									movingCards.Add (stack5 [i]);
								}
							}
						}
					}
				}
				for (int i = 4; i < stack5.Count; i++) {
					if (stack5FifthSection.Contains (new Point (current.X, current.Y))) {
						if (stack5 [4].isShowing () && !stack5 [3].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack5.Count - 4) {
									movingCards.Add (stack5 [i]);
								}
							}
						}
					}
				}
			}
			if (!moving1 && !moving3 && !moving4 && !moving5 && !moving2 && !moving7) {
				for (int i = 0; i < stack6.Count; i++) {
					if (stack6TopSection.Contains (new Point (current.X, current.Y))) {
						if (stack6 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack6.Count) {
									movingCards.Add (stack6 [i]);
								}
							}
						}

					}
				}
				for (int i = 1; i < stack6.Count; i++) {
					if (stack6SecondSection.Contains (new Point (current.X, current.Y))) {
						if (stack6 [1].isShowing () && !stack6 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack6.Count - 1) {
									movingCards.Add (stack6 [i]);
								}
							}
						}

					}
				}
				for (int i = 2; i < stack6.Count; i++) {
					if (stack6ThirdSection.Contains (new Point (current.X, current.Y))) {
						if (stack6 [2].isShowing () && !stack6 [1].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack5.Count - 2) {
									movingCards.Add (stack6 [i]);
								}
							}
						}

					}
				}
				for (int i = 3; i < stack6.Count; i++) {
					if (stack6FourthSection.Contains (new Point (current.X, current.Y))) {
						if (stack6 [3].isShowing () && !stack6 [2].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack6.Count - 3) {
									movingCards.Add (stack6 [i]);
								}
							}
						}

					}
				}
				for (int i = 4; i < stack6.Count; i++) {
					if (stack6FifthSection.Contains (new Point (current.X, current.Y))) {
						if (stack6 [4].isShowing () && !stack6 [3].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack6.Count - 4) {
									movingCards.Add (stack6 [i]);
								}
							}
						}

					}
				}
				for (int i = 5; i < stack6.Count; i++) {
					if (stack6SixthSection.Contains (new Point (current.X, current.Y))) {
						if (stack6 [5].isShowing () && !stack6 [4].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack6.Count - 5) {
									movingCards.Add (stack6 [i]);
								}
							}
						}

					}
				}
			}
			if (!moving1 && !moving3 && !moving4 && !moving5 && !moving6 && !moving2) {
				for (int i = 0; i < stack7.Count; i++) {
					if (stack7TopSection.Contains (new Point (current.X, current.Y))) {
						if (stack7 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack6.Count) {
									movingCards.Add (stack7 [i]);
								}
							}
						}

					}
				}
				for (int i = 1; i < stack7.Count; i++) {
					if (stack7SecondSection.Contains (new Point (current.X, current.Y))) {
						if (stack7 [1].isShowing () && !stack7 [0].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack7.Count - 1) {
									movingCards.Add (stack7 [i]);
								}
							}

						}
					}
				}
				for (int i = 2; i < stack7.Count; i++) {
					if (stack7ThirdSection.Contains (new Point (current.X, current.Y))) {
						if (stack7 [2].isShowing () && !stack7 [1].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack7.Count - 2) {
									movingCards.Add (stack7 [i]);
								}
							}
						}

					}
				}
				for (int i = 3; i < stack7.Count; i++) {
					if (stack7FourthSection.Contains (new Point (current.X, current.Y))) {
						if (stack7 [3].isShowing () && !stack7 [2].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack7.Count - 3) {
									movingCards.Add (stack7 [i]);
								}
							}
						}

					}
				}
				for (int i = 4; i < stack7.Count; i++) {
					if (stack7FifthSection.Contains (new Point (current.X, current.Y))) {
						if (stack7 [4].isShowing () && !stack7 [3].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack7.Count - 4) {
									movingCards.Add (stack7 [i]);
								}
							}
						}

					}
				}
				for (int i = 5; i < stack7.Count; i++) {
					if (stack7SixthSection.Contains (new Point (current.X, current.Y))) {
						if (stack7 [5].isShowing () && !stack7 [4].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack7.Count - 5) {
									movingCards.Add (stack7 [i]);
								}
							}
						}

					}
				}
				for (int i = 6; i < stack7.Count; i++) {
					if (stack7SeventhSection.Contains (new Point (current.X, current.Y))) {
						if (stack7 [6].isShowing () && !stack7 [5].isShowing ()) {
							if (current.LeftButton == ButtonState.Pressed) {

								if (movingCards.Count < stack7.Count - 6) {
									movingCards.Add (stack7 [i]);
								}
							}
						}
					}
				}
			}
		}
	}
}
