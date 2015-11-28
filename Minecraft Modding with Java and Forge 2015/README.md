# Setting Up Our Workspace

Forge is the tool that we will use to access the Minecraft [API](https://en.wikipedia.org/wiki/Application_programming_interface). An API is what allows us to easily modify the game. We will be writing the code in the Eclipse [IDE](https://en.wikipedia.org/wiki/Integrated_development_environment).

## Setting Up Eclipse

First we need to download Eclipse. Which is the tool we will be writing code  into. [It may be found here.](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/mars1) Please download the correct package for your Operating System.

Create a folder on your desktop marked "Eclipse" and move the contents from the downloaded zip file into there. Eclipse is already on the MIT PCs... hopefully.

At home, you will also need to [install the Java JDK for your appropriate OS](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

## Setting Up Forge

We will now need to download "Minecraft Forge." The hotlink to the recommended version that we will be using is [here](http://files.minecraftforge.net/maven/net/minecraftforge/forge/1.8-11.14.4.1563/forge-1.8-11.14.4.1563-mdk.zip). For future versions, you will need to go to minecraftforge.net and download the latest recommended mdk from there.

Make a new folder on your desktop marked "My Work" and place the contents from the downloaded forge zip folder in there. Next we need to build our workspace. to do this. It is different to do this in Windows and OSX/Linux.

### Windows
Hold down shift and right click in the folder, then hit "open command window here". Then type in the following.

> gradlew setupDecompWorkspace eclipse

###OSX/Linux
One must navigate to the "My Work" folder using the terminal and the "cd." command Start by typing "ls" (to see what the contents of the folder that you are in) and then use "cd" until you get to where you need to be. Once you are in "../My Work" you will need to setup the workspace similarly to how you did on Windows. Type the following into the terminal

>chmod +x gradlew

Then press enter.

>./gradlew setupDecompWorkspace eclipse

Setting up your workspace will take some time to run. I have seen it take between five and even up to twenty minutes. Be patient.

## Configuring Eclipse

If you have used eclipse before, please change your workspace to /My Work/eclipse. To do this, go to file, then switch workspace, then browse for My Work/eclipse. Be sure this is the folder marked eclipse!

Otherwise, you are new to eclipse and must set your workspace to be My Work/eclipse. Again, make sure this is the actual /eclipse/ folder and not just /My Work/.

You should now see things in Eclipse. Particularly, there is a project marked as MDKExample. This is a start to your mod!

# Programming our First Item

In the ExampleMod.java file (which is our only file). We will be adding a new method before *init* called *preinit*. Copy and paste the following code before init.


    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
        ItemManager.mainRegistry();
    }

You will then need to import "FMLPreInitializationEvent." To do this, hover over it and click the associated import option. The red line under it should then go away. What does this code do? Well, I am telling Minecraft that there is a "preinitialization event" that I want to do. In this case, all I want to do is run the method *mainRegistry* in the class definition *ItemManager*. Some of you may be confused on why I do not have to declare ItemManager as an object. This is because it is a class, not an object. Additionally, MainRegistry, and pretty much everything associated with ItemManager will be static.

Item Manager also needs to be imported, but we have not created it yet. So lets do that now.

## Creating the Item Manager

Right click on MDKExample and go to New -> Package. Name the package the following

>com.splash.item

Often. developers will name their stuff after their own domains because they are unique. I for example name my things org.jerue.whatever.

Now we are going to create a new Class. To do this, right click on the package that we just made, and navigate to New -> Class. The only thing we will want to do on the following screen is name it:

>ItemManager

Inside the body of ItemManager, copy and paste the following code:

    public static void mainRegistry() {
        initializeItem();
        registerItem();
    }

    public static void initializeItem() {
        //Constructor calls go here
    }

    public static void registerItem() {
        //Registration of Items go here
    }

As promised, the methods are static. We'll even be using static variables. Often, it is said that Minecraft is a pain to program for. This is true, and the fact that there are static variables attests to that.

A quick explanation of the methods is as follows:

### mainRegistry()

Only exists runs the other two methods.

### initializeItem

In this block, we will eventually be instantiating static variables.

###  registerItem

This will eventually add the instantiated items to the game registry in the format:

    GameRegistry.registerItem(Item item, String itemName );

## Our First Item

For our first item, we will be making an ugly purple and black block. To do this, right click on com.splash.item, and create a new class called:

>CustomItem

The first thing that we are going to want to do is give it a name. To do this, create a variable as follows in the body of CustomItem:

    public static final String name = "CustomItem";

This is **not** the name of the item that will appear ingame. We set that later. This name is what the actual backend recognizes it as. Do not put a space in it and please camelcase it exactly as I do. You **will** run into problems if you do otherwise.

we are now going to extend our class. Feel free to reread on how [inheritence](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html) works. extend CustomItem by adding:

    extends Item

to the class declaration. You will then need to import net.minecraft.item.Item. **Make sure you import the right "item" !!!** When I did this I saw several types of Item.

## Item Properties

Create a Constructor for the item by creating a new method as follows:

    public CustomItem(){
      //code go here
    }

Where I have the "code go here" comment, we are going to call the parent's constructor, add an unlocalized name, and set the creative tab. Modify the Constructor to look like this:

    public CustomItem(){
         super(); //super runs the parent's constructor
         this.setUnlocalizedName("Custom Item"); //Gives the item a name ingame
         this.setCreativeTab(CreativeTabs.tabMisc);
    }

Let's make our item do something too. In order to do so, we are going to have to create a new method that overrides the current onItemUse method... that does nothing. To do this, add the following code:

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos position, EnumFacing side, float hitX, float hitY, float hitZ){
		     world.createExplosion(player, position.getX() + hitX, position.getY() + hitY, position.getZ() + hitZ, 20f, true); //creates the boom
		     return super.onItemUse(stack, player, world, position, side, hitX, hitY, hitZ); //runs the parents onItemUse method and returns
		     //whatever that it does
    }

As a quick explanation of what this does, it takes in the ItemStack that the item is in, the player (probably you), the position of the block you are hitting, the side of the block you are hitting, and where on the block you are hitting it. Pretty in depth eh? We then create an explosion created by the player, at where you hit the block exactly in the world that the player is in. Then, the onItemUse method in the parent is run and returned.

## Texturing an Item

Texturing an item requires the creation of a square image, as well as a JSON file. When I have taught similar courses in the past, I have found most issues come with the creation of these. So, I have made them for you and you may find them [here on GitHub](https://github.com/rjerue/Splash-Teaching). Download the complete zip of all of the files, and extract the folder "resources" and place it under:

> My Work/src/main/

**Place it in Main. There should be a folder marked *java* there already.**

Now, return to examplemod and in the *init* method, add the following under the example code about dirt that is aready there:

    if(event.getSide() == Side.CLIENT){
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(ItemManager.customItem, 0,
        new ModelResourceLocation(this.MODID + ":" +
        ItemManager.customItem.name, "inventory"));
    }

**Check to make sure that you are importing the correct things.**

Now, press the green run button in Eclipse. Your item will be textured under the Misc tab.

# Building the mod

As you did when you ran the original command to open the workspace, open the terminal or command line in the "My Work" folder. Then, you will need to run either:

### On Windows

> gradlew.bat build

### On OSX/Linux

> ./gradlew build

Your mod should then be in a folder marked build/libs. You may use this JAR file on any Forge installation by putting it in the mods folder. Do note that I added a second sword item in the class because I had extra time. Its creation is not specifically covered in this writeup, but it is pretty self explanatory and commented.

Happy Coding, and enjoy!
