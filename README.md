# Swapbar

This Minecraft mod adds a simple keybind that allows you to swap your hotbar for the row in your inventory above it. It specifically cycles each row of your inventory down one, with your hotbar moving to the top. Holding down 'alt' will cycle in the opposite way; each row shifting up, and the top row wrapping down to your hotbar.

For example, given this inventory: 

![Minecraft inventory filled with survival items. Tools and blocks in the hotbar/4th row, farming items in the 3rd row, fishing items in the 2nd row, and mob drops in the 1st row.](https://github.com/zandgall/Swapbar/assets/38407831/023e7a19-a19d-4ccf-b7dc-56835ffc1b83)

Now hitting the swapbar key, the inventory then holds:

![The same inventory after hitting the swapbar key. The inventory now has Farming items in the hotbar/4th row, fishing items in the 3rd row, mob items in the 2nd row, and tools and blocks in the top/first row.](https://github.com/zandgall/Swapbar/assets/38407831/e149e5f0-728f-4bdb-9c4c-da6c895a326b)

If you then hit the swapbar key while holding down the Alt key, you can see that it swaps in the opposite direction, returning to the original state.

# Building

Clone / download this repository. It can be built with gradle in whatever IDE you use, or even in the command line. I used IntelliJ IDEA, in which you can import this gradle project and build through the gradle menu.
