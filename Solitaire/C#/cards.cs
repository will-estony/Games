using System;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Storage;
using Microsoft.Xna.Framework.Input;
namespace four
{
	public class cards
	{
		int color;
		int suit;
		int value;
		Rectangle source;
		Boolean showing; 
		String[] suits = { "Spades", "Clubs", "Diamonds", "Hearts" };
		String[] values = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
		private static Rectangle back = new Rectangle (0, 469, 81, 119);

		public cards (int color, int suit, int value, Rectangle source)
		{
			this.color = color;
			this.suit = suit;
			this.value = value;
			this.source = source;
		}

		public int getColor()
		{
			return color;
		}

		public int getSuit()
		{
			return suit;
		}
		public String getSuitString(){
			return suits [suit];
		}

		public int getValue(){
			return value;
		}
		public String getValueString(){
			return values [value];
		}
		public Boolean isShowing(){
			return showing;
		}

		public static void setBackRectangle(int x, int y, int w, int h){
			back.X = x;
			back.Y = y;
			back.Width = w;
			back.Height = h;
		}

		public Rectangle getSource()
		{
			if (showing)
				return source;
			else
				return back;
		
		}
		public void flip(){
			showing = !showing;
		}
		public string toString(){
			if (showing)
				return "face up is a" + getValueString () + "of" + getSuitString ();
			else
				return "face down is a" + getValueString () + "of" + getSuitString ();
		}
	}
}

