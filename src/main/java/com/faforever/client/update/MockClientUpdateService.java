package com.faforever.client.update;

import com.faforever.client.FafClientApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Lazy
@Service
@Profile(FafClientApplication.PROFILE_OFFLINE)
@Slf4j
public class MockClientUpdateService implements ClientUpdateService {

  @Override
  public CompletableFuture<UpdateInfo> getNewestUpdate() {
    return CompletableFuture.completedFuture(null);
  }

  @Override
  public void checkForUpdateInBackground() {

  }

  @Override
  public String getCurrentVersion() {
    return "0.10.1";
  }

  @Override
  public ClientUpdateTask updateInBackground(UpdateInfo updateInfo) {
    return new ClientUpdateTask(null, null) {
      @Override
      protected Void call() {
        log.info("Mock updating client");
        return null;
      }
    };
  }
}
