/*
 * Copyright (c) 2014, Vladimir Olteanu
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 * disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package soulsbestclass.games;

import soulsbestclass.Game;

public class DemonsSoulsGame extends Game
{
	class DemonsSoulsChar extends soulsbestclass.Character
	{
		DemonsSoulsChar(String name, int lvl, int vit, int intel, int end, int str, int dex, int mag, int fai, int luck)
		{
			this.name = name;
			level = lvl;

			stats.put("Vitality",     vit);
			stats.put("Intelligence", intel);
			stats.put("Endurance",    end);
			stats.put("Strength",     str);
			stats.put("Dexterity",    dex);
			stats.put("Magic",        mag);
			stats.put("Faith",        fai);
			stats.put("Luck",         luck);
		}
	}
	
	public DemonsSoulsGame()
	{
		super("Demon's Souls");
		
		classes.add(new DemonsSoulsChar("Soldier",       6, 14,  9, 12, 12, 11,  8, 10, 10));
		classes.add(new DemonsSoulsChar("Knight",        4, 10, 11, 11, 14, 10, 10, 11,  7));
		classes.add(new DemonsSoulsChar("Hunter",        6, 12, 10, 13, 11, 12,  8,  8, 12));
		classes.add(new DemonsSoulsChar("Priest",        6, 13, 11, 12, 13,  8,  8, 13,  8));
		classes.add(new DemonsSoulsChar("Magician",      6,  9, 15, 10,  9, 11, 15,  6, 11));
		classes.add(new DemonsSoulsChar("Wanderer",      6, 10, 10, 11, 11, 15,  9,  7, 13));
		classes.add(new DemonsSoulsChar("Barbarian",     9, 15,  7, 13, 15,  9, 11,  8, 11));
		classes.add(new DemonsSoulsChar("Thief",         9, 10, 13, 10,  9, 14, 10,  8, 15));
		classes.add(new DemonsSoulsChar("Temple Knight", 4, 11,  8, 13, 14, 12,  6, 13,  7));
		classes.add(new DemonsSoulsChar("Royalty",       1,  8, 12,  8,  9, 12, 13, 12,  7));
		
		stats = classes.iterator().next().getStats().keySet();
	}
}
