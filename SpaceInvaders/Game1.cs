using System;

using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Storage;
using Microsoft.Xna.Framework.Input;

namespace will_estonySpaceInvaders
{
	/// <summary>
	/// This is the main type for your game.
	/// </summary>
	public class Game1 : Game
	{
		GraphicsDeviceManager graphics;
		SpriteBatch spriteBatch;
		Texture2D background;
		Texture2D source;
		Rectangle cannon;
		Vector2 cannonPos;
		Rectangle firstAlien;
		Vector2 firstAlienPos;
		Vector2 firstAlienVelocity;
		Rectangle bullet;
		Vector2 bulletPos;
		Vector2 bulletVelocity;
		Rectangle firstAlienOnScreen; 
		SpriteFont font;
		int score = 0;
		Rectangle[] aliens = new Rectangle[6 * 10];
		Rectangle secondAlien;
		public Game1 ()
		{
			graphics = new GraphicsDeviceManager (this);
			Content.RootDirectory = "Content";
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
			cannonPos.X = 350;
			cannonPos.Y = 425;
			bulletPos.X = 395;
			bulletPos.Y = 425;
			bulletVelocity = new Vector2 (0, 0);
			firstAlienPos.X = 250;
			firstAlienPos.Y = 50;
			firstAlienVelocity = new Vector2 (1, 0);


					

			base.Initialize ();

		
		

		}
		/// <summary>
		/// LoadContent will be called once per game and is the place to load
		/// all of your content.
		/// </summary>
		protected override void LoadContent ()
		{
			// Create a new SpriteBatch, which can be used to draw textures.
			spriteBatch = new SpriteBatch (GraphicsDevice);
			background = Content.Load<Texture2D> ("background");
			source = Content.Load<Texture2D> ("allSprites");
			cannon = new Rectangle (25, 196, 100, 55);
			bullet = new Rectangle (70, 115, 15, 50);
			firstAlien = new Rectangle (5, 60, 60, 40);
			secondAlien = new Rectangle (70, 60, 60, 40);
			font = Content.Load<SpriteFont> ("font");
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
			#if !__IOS__ &&  !__TVOS__
			if (GamePad.GetState (PlayerIndex.One).Buttons.Back == ButtonState.Pressed || Keyboard.GetState ().IsKeyDown (Keys.Escape))
				Exit ();
			#endif
			if (firstAlienPos.X > 500)
				firstAlienVelocity.X *= -1;
			if (firstAlienPos.X < 0)
				firstAlienVelocity.X *= -1;
			//
			//prevents the cannon from going off the screen and allows the bullet to follow the cannon
			//also changes the y velocity of the cannon whenever the spacebar is pressed
			if(Keyboard.GetState ().IsKeyDown(Keys.Left) && cannonPos.X>0&& bulletVelocity.Y ==0){
				
				bulletPos.X -=3;
			}
			if(Keyboard.GetState ().IsKeyDown(Keys.Right)&& cannonPos.X<700&& bulletVelocity.Y ==0){
				bulletPos.X +=3;
			}
			if(Keyboard.GetState ().IsKeyDown(Keys.Right)&& cannonPos.X<700){
				cannonPos.X +=3;

			}

			if (Keyboard.GetState ().IsKeyDown (Keys.Left) && cannonPos.X > 0) {
				cannonPos.X -= 3;
			}

			if(Keyboard.GetState ().IsKeyDown(Keys.Space)){
				bulletVelocity.Y += 2;
			}
			if (bulletPos.Y < 0) {
				bulletVelocity.Y = 0;
				bulletPos.X = cannonPos.X + 45;
				bulletPos.Y = 425;
			}
			if (true == true) {
				
				firstAlienPos.X += firstAlienVelocity.X;
				bulletPos.X += bulletVelocity.X;
				bulletPos.Y -= bulletVelocity.Y;

			}
			//firstAlienOnScreen = new Rectangle ((int)firstAlienPos.X, (int)firstAlienPos.Y, 60, 40);
			Point p1;
			p1 = new Point ((int)bulletPos.X + (int)bullet.Width / 2, (int)bulletPos.Y + (int)bullet.Height);

			//These represent the rows and colums 
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 5; j++) {
					for (int c = 0; c < aliens.Length; c++) {
						//This is supposed to take the aliens off the screen but I have no clue what I'am doing
						if (aliens [c].X < 3001) {
							aliens [j * 4 + i] = new Rectangle (j * 60 + (int)firstAlienPos.X, i * 40 + (int)firstAlienPos.Y, 60, 40);
						}
					}
				}
			}

			// TODO: Add your update logic here
			
			for (int i = 0; i < aliens.Length; i++) {
				if (aliens [i].Contains (p1)) {
					aliens[i].X = 3001;
					aliens[i].Y = 3001;
					bulletVelocity.Y = 0;
					bulletPos.X = cannonPos.X + 45;
					bulletPos.Y = 425;
					score++;
							}
						}
			
            
			base.Update (gameTime);
		}

		/// <summary>
		/// This is called when the game should draw itself.
		/// </summary>
		/// <param name="gameTime">Provides a snapshot of timing values.</param>
		protected override void Draw (GameTime gameTime)
		{
			
			graphics.GraphicsDevice.Clear (Color.Green);
			spriteBatch.Begin ();
			//TODO: Add your drawing code here
			spriteBatch.Draw(background,new Vector2(0,0),Color.White);
			spriteBatch.Draw (source, bulletPos, bullet, Color.White);
			spriteBatch.Draw (source, cannonPos, cannon, Color.White);

			spriteBatch.DrawString (font, "Score " + score, new Vector2 (50, 50), Color.White);


			for (int i = 0; i < aliens.Length; i++) {
				spriteBatch.Draw (source, aliens [i], firstAlien, Color.White);
			}
			for (int i = 0; i < aliens.Length; i++) {
				spriteBatch.Draw (source, aliens [i], secondAlien, Color.White);
			}

			spriteBatch.End ();
			base.Draw (gameTime);
		}
	}
}

