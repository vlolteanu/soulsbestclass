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

public class DarkSouls2Game extends soulsbestclass.Game
{
	class DarkSouls2Char extends soulsbestclass.Character
	{
		DarkSouls2Char(String name, int lvl, int vig, int end, int vit, int att, int str, int dex, int ada, int intel, int fai)
		{
			this.name = name;
			level = lvl;
			
			stats.put("Vigor",        vig);
			stats.put("Endurance",    end);
			stats.put("Vitality",     vit);
			stats.put("Attunement",   att);
			stats.put("Strength",     str);
			stats.put("Dexterity",    dex);
			stats.put("Adaptability", ada);
			stats.put("Intelligence", intel);
			stats.put("Faith",        fai);
		}
	}
	
	public DarkSouls2Game()
	{
		super("Dark Souls 2");
		
		classes.add(new DarkSouls2Char("Warrior",   12,  7,  6,  6,  5, 15, 11,  5,  5,  5));
		classes.add(new DarkSouls2Char("Knight",    13, 12,  6,  7,  4, 11,  8,  9,  3,  6));
		classes.add(new DarkSouls2Char("Swordsman", 12,  4,  8,  4,  6,  9, 16,  6,  7,  5));
		classes.add(new DarkSouls2Char("Bandit",    11,  9,  7, 11,  2,  9, 14,  3,  1,  8));
		classes.add(new DarkSouls2Char("Cleric",    14, 10,  3,  8, 10, 11,  5,  4,  4, 12));
		classes.add(new DarkSouls2Char("Sorcerer",  11,  5,  6,  5, 12,  3,  7,  8, 14,  4));
		classes.add(new DarkSouls2Char("Explorer",  10,  7,  6,  9,  7,  6,  6, 12,  5,  5));
		classes.add(new DarkSouls2Char("Deprived",   1,  6,  6,  6,  6,  6,  6,  6,  6,  6));
		
		stats = classes.iterator().next().getStats().keySet();
	}
}
