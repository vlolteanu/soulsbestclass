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

import java.util.LinkedHashMap;
import java.util.Map;

public class Character implements Comparable<Character>
{
	protected String name;
	protected int level;
	protected Map<String, Integer> stats = new LinkedHashMap<String, Integer>();

	public Map<String, Integer> getStats()
	{
		return stats;
	}
	
	protected Character() {}
	
	Character(Character o)
	{
		name = o.name;
		level = o.level;
		stats.putAll(o.stats);
	}
	
	/* the desired stats must be normalized */
	Character propose(Map<String, Integer> desiredStats)
	{
		Character ret = new Character(this);
		
		for (String statName: desiredStats.keySet())
		{
			int value = stats.get(statName);
			int desiredValue = desiredStats.get(statName);
			
			if (desiredValue > value)
			{
				ret.level += desiredValue - value;
				ret.stats.put(statName, desiredValue);
			}
		}
		
		return ret;
	}
	
	@Override
	public String toString()
	{
		String ret = "Name:\t" + name + "\n" +
			"Level:\t" + level + "\n";
		
		for (String stat: stats.keySet())
			ret += stat + "\t" + stats.get(stat) + "\n";
		
		return ret;
	}

	@Override
	public int compareTo(Character o)
	{
		boolean someGTStat = false;
		boolean someLTStat = false;
		
		if (o == null)
			throw new NullPointerException();
		
		/* lower soul level is always better*/
		if (this.level != o.level)
			return o.level - this.level;
		
		for (String statName: stats.keySet())
		{
			int value = stats.get(statName);
			int oValue = o.stats.get(statName);
			
			if (value > oValue)
				someGTStat = true;
			else if (value < oValue)
				someLTStat = true;
		}
		
		/* 
		 * no or ambiguous stat differences
		 * (we could have taken the starting lvl into account,
		 * but the difference in souls spent is minuscule and prolly offset by starting gear)
		 */
		if (someGTStat == someLTStat)
			return 0;
		
		/* obvious stat differences */
		if (someGTStat)
			return 1;
		if (someLTStat)
			return -1;
		
		/* this is never reached */
		return 0;
	}
}
