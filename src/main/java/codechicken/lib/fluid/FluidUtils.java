package codechicken.lib.fluid;

import io.github.fabricators_of_create.porting_lib.util.FluidAttributes;
import io.github.fabricators_of_create.porting_lib.util.FluidStack;
import io.github.fabricators_of_create.porting_lib.util.FluidUnit;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class FluidUtils {

    public static FluidUnit B = FluidUnit.MILIBUCKETS;
    public static FluidStack water = new FluidStack(Fluids.WATER, 1000);
    public static FluidStack lava = new FluidStack(Fluids.LAVA, 1000);

    public static int getLuminosity(FluidStack stack, double density) {
        if (stack.isEmpty()) {
            return 0;
        }
        Fluid fluid = stack.getFluid();
        FluidAttributes type = fluid.getAttributes(); //TODO: Figure out what the hell is meant by new 1.19 system.
        int light = type.getLuminosity(stack);
        if (type.isLighterThanAir()) {
            light = (int) (light * density);
        }
        return light;
    }
}
