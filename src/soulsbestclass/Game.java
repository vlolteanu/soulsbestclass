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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Game
{
	String name;
	protected Set<Character> classes = new LinkedHashSet<Character>();
	protected Set<String> stats = null;
	protected Iterable<Tiebreaker> tiebreakers = new LinkedList<Tiebreaker>();

	public Game(String name)
	{
		this.name = name;
	}

	public Set<String> getStats()
	{
		return stats;
	}
	
	Map<String, Integer> normalize(Map<String, Integer> desiredStats) throws Exception
	{
		Map<String, Integer> ret = new HashMap<String, Integer>();
		
		for (String statName: desiredStats.keySet())
		{
			String candidate = null;
			
			for (String existingStatName: stats)
			{
				if (existingStatName.toUpperCase().startsWith(statName.toUpperCase()))
				{
					if (candidate == null)
						candidate = existingStatName;
					else
						throw new Exception("Ambigous stat: " + statName);
				}
			}
			
			if (candidate == null)
				throw new Exception("No such stat: " + statName);
			
			ret.put(candidate, desiredStats.get(statName));
		}
		
		return ret;
	}
	
	List<Character> propose(Map<String, Integer> desiredStatsMurky) throws Exception
	{
		List<Character> proposals = new LinkedList<Character>();
		Map<String, Integer> desiredStats = normalize(desiredStatsMurky);
		
		for (Character startingChar: classes)
		{
			Character proposal1 = startingChar.propose(desiredStats);
			boolean add = true;
			
			for (Iterator<Character> it = proposals.iterator(); it.hasNext();)
			{
				Character proposal2 = it.next();
				int result = proposal1.compareTo(proposal2);
				
				if (result == 0)
				{
					Character c1 = new Character(proposal1);
					Character c2 = new Character(proposal2);
					
					for (Tiebreaker tiebreaker: tiebreakers)
					{
						tiebreaker.adjust(c1);
						tiebreaker.adjust(c2);
						
						result = c1.compareTo(c2);
						if (result != 0)
							break;
					}
					
				}
				
				if (result < 0)
				{
					add = false;
					break;
				}
				else if (result > 0)
				{
					it.remove();
				}
			}
			
			if (add)
				proposals.add(proposal1);
		}
		
		return proposals;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
