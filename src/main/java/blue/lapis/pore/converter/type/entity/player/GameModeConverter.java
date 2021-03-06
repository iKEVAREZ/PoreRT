/*
 * Pore(RT)
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
 * Copyright (c) 2014-2016, Contributors
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package blue.lapis.pore.converter.type.entity.player;

import static org.bukkit.GameMode.NOT_SET;
import static org.bukkit.GameMode.ADVENTURE;
import static org.bukkit.GameMode.CREATIVE;
import static org.bukkit.GameMode.SPECTATOR;
import static org.bukkit.GameMode.SURVIVAL;

import blue.lapis.pore.converter.type.TypeConverter;

import com.google.common.base.Converter;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;

public final class GameModeConverter {

    private GameModeConverter() {
    }

    private static final Converter<org.bukkit.GameMode, GameMode> CONVERTER =
            TypeConverter.builder(org.bukkit.GameMode.class, GameMode.class)
                    .add(NOT_SET, GameModes.NOT_SET)
                    .add(SURVIVAL, GameModes.SURVIVAL)
                    .add(CREATIVE, GameModes.CREATIVE)
                    .add(ADVENTURE, GameModes.ADVENTURE)
                    .add(SPECTATOR, GameModes.SPECTATOR)
                    .build();

    public static GameMode of(org.bukkit.GameMode gameMode) {
        return CONVERTER.convert(gameMode);
    }

    public static org.bukkit.GameMode of(GameMode gameMode) {
        return CONVERTER.reverse().convert(gameMode);
    }

}
