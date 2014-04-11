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

package soulsbestclass;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import soulsbestclass.games.DarkSouls2Game;
import soulsbestclass.games.DarkSoulsGame;
import soulsbestclass.games.DemonsSoulsGame;

public class SoulsBestClass
{
	static Map<String, Game> games = new LinkedHashMap<String, Game>();
	
	static void addGames()
	{
		games.put("demon", new DemonsSoulsGame());
		games.put("dark",  new DarkSoulsGame());
		games.put("dark2", new DarkSouls2Game());
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		addGames();
		
		if (args.length == 0 || (args.length - 1) %2 != 0)
		{
			System.err.println("Args:\n" +
				"\t<game name> [<stat name> <value> [<stat name> <value> [...]]]\n" +
				"where game is one of:");
			for (String game: games.keySet())
				System.err.println("\t" + game + games.get(game));
		}
		
		Game game = games.get(args[0]);
		Map<String, Integer> desiredStats = new HashMap<String, Integer>();
		
		for (int i = 1; i < args.length; i += 2)
			desiredStats.put(args[i], Integer.parseInt(args[i + 1]));
		
		List<Character> proposals = null;
		try
		{
			proposals = game.propose(desiredStats);
		} catch (Exception ex)
		{
			Logger.getLogger(SoulsBestClass.class.getName()).log(Level.SEVERE, null, ex);
			System.exit(1);
		}
		
		for (Character character: proposals)
			System.out.println(character);
	}
}
