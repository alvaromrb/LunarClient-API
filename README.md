# LunarClient-API

How to include the API with Maven:
```xml
<dependencies>
    <dependency>
        <groupId>net.silexpvp</groupId>
        <artifactId>lunarclientapi</artifactId>
        <version>1.0-SNAPSHOT</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```
## Implementing the API
Implementing this api is not hard, just follow the example below:

```java
package net.example.plugin;

import java.util.logging.Logger;

import net.silexpvp.lunar.LunarClientAPI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        new LunarClientAPI(this);
    }
    
    public void sendNotification(Player player) {
        LCPacketNotification packet = new LCPacketNotification("You have been authenticated", TimeUnit.SECONDS.toMillis(5), LCPacketNotification.Level.INFO);
        packet.send(player);
    }
}
```
