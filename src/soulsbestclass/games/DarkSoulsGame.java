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

import soulsbestclass.tiebreakers.StatIgnoreTiebreaker;

public class DarkSoulsGame extends soulsbestclass.Game
{
	class DarkSoulsChar extends soulsbestclass.Character
	{
		DarkSoulsChar(String name, int lvl, int vit, int att, int end, int str, int dex, int res, int intel,
			int fai)
		{
			this.name = name;
			level = lvl;

			stats.put("Vitality",     vit);
			stats.put("Attunement",   att);
			stats.put("Endurance",    end);
			stats.put("Strength",     str);
			stats.put("Dexterity",    dex);
			stats.put("Resistance",   res);
			stats.put("Intelligence", intel);
			stats.put("Faith",        fai);
		}
	}
	
	public DarkSoulsGame()
	{
		super("Dark Souls");
		
		classes.add(new DarkSoulsChar("Warrior",    4, 11,  8, 12, 13, 13, 11,  9,  9));
		classes.add(new DarkSoulsChar("Knight",     5, 14, 10, 10, 11, 11, 10,  9, 11));
		classes.add(new DarkSoulsChar("Wanderer",   3, 10, 11, 10, 10, 14, 12, 11,  8));
		classes.add(new DarkSoulsChar("Thief",      5,  9, 11,  9,  9, 15, 10, 12, 11));
		classes.add(new DarkSoulsChar("Bandit",     4, 12,  8, 14, 14,  9, 11,  8, 10));
		classes.add(new DarkSoulsChar("Hunter",     4, 11,  9, 11, 12, 14, 11,  9,  9));
		classes.add(new DarkSoulsChar("Sorcerer",   3,  8, 15,  8,  9, 11,  8, 15,  8));
		classes.add(new DarkSoulsChar("Pyromancer", 1, 10, 12, 11, 12,  9, 12, 10,  8));
		classes.add(new DarkSoulsChar("Cleric",     2, 11, 11,  9, 12,  8, 11,  8, 14));
		classes.add(new DarkSoulsChar("Deprived",   6, 11, 11, 11, 11, 11, 11, 11, 11));
		
		stats = classes.iterator().next().getStats().keySet();
	}
}
